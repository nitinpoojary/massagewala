package com.example.nitin.massagewala.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.nitin.massagewala.Adapter.HomeContentAdapter;
import com.example.nitin.massagewala.Model.HomeContent;
import com.example.nitin.massagewala.R;
import com.example.nitin.massagewala.lib.Config;
import com.example.nitin.massagewala.volley.VolleySingleton;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by NITIN on 7/13/2017.
 */

public class HomeFragment extends Fragment {
	private SliderLayout mDemoSlider;
	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	ArrayList<HomeContent> arrayList;
	RequestQueue requestQueue;
	public static HomeContent homeContent=new HomeContent();

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_fragment, container, false);
		init(view);
		return view;
	}

	private void init(View view) {
		mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

		HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
		file_maps.put("Hannibal", R.drawable.one);
		file_maps.put("Big Bang Theory", R.drawable.two);
		file_maps.put("House of Cards", R.drawable.three);
		file_maps.put("Game of Thrones", R.drawable.four);

		for (String name : file_maps.keySet()) {
			TextSliderView textSliderView = new TextSliderView(getActivity());
			// initialize a SliderLayout
			textSliderView
					.description(name)
					.image(file_maps.get(name))
					.setScaleType(BaseSliderView.ScaleType.Fit);

			//add your extra information
			textSliderView.bundle(new Bundle());
			textSliderView.getBundle()
					.putString("extra", name);

			mDemoSlider.addSlider(textSliderView);
		}
		requestQueue = VolleySingleton.getsInstance().getmRequestQueue();
		recyclerView = (RecyclerView) view.findViewById(R.id.rv_home);
		layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(layoutManager);
		arrayList = new ArrayList<>();
		CallMassageList();
	}

	private void CallMassageList() {

		/*JsonObjectRequest objectRequest = new JsonObjectRequest(Config.JSON_URL, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(objectRequest);*/
		homeContent.setTitle("Head Massage");
		homeContent.setDescription("sfjsfd jsfsdklfjdsj ssddfjsfkldf");
		homeContent.setPrice("350");
		arrayList.add(homeContent);

		homeContent.setTitle("Body Massage");
		homeContent.setDescription("sfjsfd jsfsdklfjdsj ssddfjsfkldf");
		homeContent.setPrice("350");
		arrayList.add(homeContent);

		homeContent.setTitle("Leg Massage");
		homeContent.setDescription("sfjsfd jsfsdklfjdsj ssddfjsfkldf");
		homeContent.setPrice("350");
		arrayList.add(homeContent);



		HomeContentAdapter adapter=new HomeContentAdapter(getActivity(),arrayList);

		recyclerView.setAdapter(adapter);
	}
}


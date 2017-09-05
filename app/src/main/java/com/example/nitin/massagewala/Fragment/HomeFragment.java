package com.example.nitin.massagewala.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.nitin.massagewala.Activity.MainActivity;
import com.example.nitin.massagewala.Adapter.HomeContentAdapter;
import com.example.nitin.massagewala.Model.HomeContent;
import com.example.nitin.massagewala.Model.Slider;
import com.example.nitin.massagewala.R;
import com.example.nitin.massagewala.lib.Config;
import com.example.nitin.massagewala.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment implements HomeContentAdapter.openOils {
	private SliderLayout mDemoSlider;
	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	ArrayList<HomeContent> arrayList;
	ArrayList<Slider> sliderList;
	RequestQueue requestQueue;
	MainActivity mainActivity;
	HomeContentAdapter adapter;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_fragment, container, false);
		init(view);
		return view;
	}

	private void init(View view) {
		requestQueue = VolleySingleton.getsInstance().getmRequestQueue();

		mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
		mainActivity= (MainActivity) getActivity();
		sliderList = new ArrayList<>();
        getSliderUrl();


		recyclerView = (RecyclerView) view.findViewById(R.id.rv_home);
		layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
		getMassageList();

	}

	private void getSliderUrl() {
		StringRequest stringRequest = new StringRequest(Config.JSON_URL + "getSlider", new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					Log.d(Config.TAG, "Responce:" + response);
					JSONArray jsonArray = new JSONArray(response);

					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						sliderList.add(new Slider(jsonObject));
					}
					fillSlider();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(stringRequest);
	}

	private void fillSlider() {
		for (Slider slider : sliderList) {
			TextSliderView textSliderView = new TextSliderView(getActivity());
			// initialize a SliderLayout
			textSliderView
					.description(slider.getSliderHeading())
					.image(Config.SLIDER_IMAGE + slider.getSliderImage())
					.setScaleType(BaseSliderView.ScaleType.Fit);
			//add your extra information
			textSliderView.bundle(new Bundle());
			textSliderView.getBundle().putString("extra", slider.getSliderText());
			mDemoSlider.addSlider(textSliderView);
		}
	}

	private void getMassageList() {

		adapter = new HomeContentAdapter(getActivity(), arrayList,this);
		recyclerView.setAdapter(adapter);
		JsonArrayRequest arrayRequest = new JsonArrayRequest(Config.JSON_URL+"getMassageList", new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {
				for(int i=0;i<response.length();i++){
					try {
						HomeContent homeContent = new HomeContent(response.getJSONObject(i));
						arrayList.add(homeContent);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				adapter.notifyDataSetChanged();
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(getActivity().getApplicationContext(), "Loading Failed", Toast.LENGTH_SHORT).show();
			}
		});
		requestQueue.add(arrayRequest);

	}

	@Override
	public void oilsCallBack() {
		mainActivity.loadFragment(new OilSelectionFragment(),true);
	}
}


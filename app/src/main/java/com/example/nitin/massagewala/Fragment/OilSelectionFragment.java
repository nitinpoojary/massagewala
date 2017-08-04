package com.example.nitin.massagewala.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.nitin.massagewala.Adapter.OileSelectionAdapter;
import com.example.nitin.massagewala.Model.OilSelection;
import com.example.nitin.massagewala.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 8/5/2017.
 */

public class OilSelectionFragment extends Fragment {
	Button btnViewCart;
	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	ArrayList<OilSelection> selectionArrayList;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.oilselection_fragment, container);
		recyclerView = (RecyclerView) view.findViewById(R.id.rvOils);
		layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.DEFAULT_SPAN_COUNT, false);
		recyclerView.setLayoutManager(layoutManager);
		selectionArrayList = new ArrayList<>();

		callOils();
		return view;
	}

	private void callOils() {
		OilSelection oilSelection = new OilSelection();
		oilSelection.setId(1);
		oilSelection.setTitle("Nitin");
		oilSelection.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oilSelection);

		oilSelection.setId(2);
		oilSelection.setTitle("Nitin");
		oilSelection.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oilSelection);

		oilSelection.setId(3);
		oilSelection.setTitle("Nitin");
		oilSelection.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oilSelection);

		oilSelection.setId(4);
		oilSelection.setTitle("Nitin");
		oilSelection.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oilSelection);

		OileSelectionAdapter adapter=new OileSelectionAdapter(getActivity(),selectionArrayList);

	}
}

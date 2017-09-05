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

import com.example.nitin.massagewala.Activity.MainActivity;
import com.example.nitin.massagewala.Adapter.OileSelectionAdapter;
import com.example.nitin.massagewala.Model.Oil;
import com.example.nitin.massagewala.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 8/5/2017.
 */

public class OilSelectionFragment extends Fragment {
	Button btnViewCart;
	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	ArrayList<Oil> selectionArrayList;
	MainActivity mainActivity;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.oilselection_fragment, container,false);
		recyclerView = (RecyclerView) view.findViewById(R.id.rvOils);
		layoutManager = new GridLayoutManager(getActivity(),2);
		recyclerView.setLayoutManager(layoutManager);
		selectionArrayList = new ArrayList<>();
		mainActivity= (MainActivity) getActivity();
		callOils();
		return view;
	}

	private void callOils() {
		Oil oil = new Oil();
		oil.setId(1);
		oil.setTitle("Nitin");
		oil.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oil);

		oil.setId(2);
		oil.setTitle("Nitin");
		oil.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oil);

		oil.setId(3);
		oil.setTitle("Nitin");
		oil.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oil);

		oil.setId(4);
		oil.setTitle("Nitin");
		oil.setDescription("dahdjkhsahdadasd");
		selectionArrayList.add(oil);

		OileSelectionAdapter adapter=new OileSelectionAdapter(getActivity(),selectionArrayList);
		recyclerView.setAdapter(adapter);

	}
}

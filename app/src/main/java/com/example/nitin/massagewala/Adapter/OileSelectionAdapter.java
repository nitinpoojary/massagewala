package com.example.nitin.massagewala.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nitin.massagewala.Model.OilSelection;
import com.example.nitin.massagewala.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 8/5/2017.
 */

public class OileSelectionAdapter extends RecyclerView.Adapter<OileSelectionAdapter.ViewHolder> {
	Context context;
	ArrayList<OilSelection> selectionArrayList;

	public OileSelectionAdapter(Activity activity, ArrayList<OilSelection> oilSelection) {
		this.context=activity;
		this.selectionArrayList=oilSelection;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view= LayoutInflater.from(context).inflate(R.layout.custom_oil_row,parent,false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return selectionArrayList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		public ViewHolder(View itemView) {
			super(itemView);
		}
	}
}

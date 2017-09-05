package com.example.nitin.massagewala.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nitin.massagewala.Model.Oil;
import com.example.nitin.massagewala.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 8/5/2017.
 */

public class OileSelectionAdapter extends RecyclerView.Adapter<OileSelectionAdapter.ViewHolder> {
	Context context;
	ArrayList<Oil> selectionArrayList;


	public OileSelectionAdapter(Activity activity, ArrayList<Oil> oil) {
		this.context=activity;
		this.selectionArrayList= oil;

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view= LayoutInflater.from(context).inflate(R.layout.custom_oil_row,parent,false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Oil oil =selectionArrayList.get(position);
		holder.tvTitle.setText(oil.getTitle());
		holder.tvDescription.setText(oil.getDescription());
	}

	@Override
	public int getItemCount() {
		return selectionArrayList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		TextView tvTitle,tvDescription;

		public ViewHolder(View itemView) {
			super(itemView);

			tvTitle=(TextView)itemView.findViewById(R.id.tvOilTitle);
			tvDescription=(TextView)itemView.findViewById(R.id.tvOilDiscription);


		}
	}
}

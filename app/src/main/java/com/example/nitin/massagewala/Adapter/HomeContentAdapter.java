package com.example.nitin.massagewala.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nitin.massagewala.Model.HomeContent;
import com.example.nitin.massagewala.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 7/26/2017.
 */

public class HomeContentAdapter extends RecyclerView.Adapter<HomeContentAdapter.MyViewHolder> {

	Context context;
	ArrayList<HomeContent> arrayList;

	public HomeContentAdapter(Context context, ArrayList<HomeContent> arrayList) {
		this.context = context;
		this.arrayList = arrayList;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.custom_row, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		HomeContent homeContent = arrayList.get(position);
		holder.tv_title.setText(homeContent.getTitle());
		holder.tv_custom_description.setText(homeContent.getDescription());
		holder.tv_custom_title.setText(homeContent.getTitle());

	}

	@Override
	public int getItemCount() {
		return arrayList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		TextView tv_title, tv_custom_description, tv_custom_title;
		Button btn_bookNow, btn_custom_bookNow;
		RelativeLayout relativeLayout;

		public MyViewHolder(View itemView) {
			super(itemView);
			relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rv_customview);
			tv_title = (TextView) itemView.findViewById(R.id.tv_custom_title);
			tv_custom_description = (TextView) itemView.findViewById(R.id.tv_custom_description);
			tv_custom_title = (TextView) itemView.findViewById(R.id.tv_custom_title);
			btn_bookNow=(Button)itemView.findViewById(R.id.btn_OrderNow);
			btn_bookNow.setOnClickListener(this);
			btn_custom_bookNow=(Button)itemView.findViewById(R.id.btn_custom_booknow);
			btn_custom_bookNow.setOnClickListener(this);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if (v.getId()==R.id.btn_OrderNow){

			}else if (v.getId()==R.id.btn_custom_booknow){

			}else {

			}
		}
	}
}

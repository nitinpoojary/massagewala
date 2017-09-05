package com.example.nitin.massagewala.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeContent {
	private String image;
	private String title;
	private String description;
	private String price;
	private List<Oil> oilList = new ArrayList<>();

    public HomeContent(JSONObject jsonObject) {
		try {
			this.image = jsonObject.getString("massage_pic");
			this.title = jsonObject.getString("massage_name");
			this.description = jsonObject.getString("massage_info");
			this.price = jsonObject.getString("massage_price");
			ArrayList<Oil> oils = new ArrayList<>();
			/*JSONArray jsonArray = jsonObject.getJSONArray("oil_list");
			for (int i = 0; i <jsonArray.length() ; i++) {
				Oil oil = new Oil(jsonArray.getJSONObject(i));
				oils.add(oil);
			}
			this.oilList=oils;*/

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
	public HomeContent() {
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

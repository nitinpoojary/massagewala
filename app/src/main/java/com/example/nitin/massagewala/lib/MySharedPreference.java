package com.example.nitin.massagewala.lib;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;


public class MySharedPreference {

	private Context context;
	private SharedPreferences sharedpreferences;
	private static final String USER_JSON = "myuser";
	private static final String USER_ID="user_id";
	private static final String USER_NAME ="user_name";
	private static final String USER_MOBILE ="user_mobile";
	private static final String USER_EMAIL ="user_email";
	private static final String USER_DEGREE="user_degree";
	private static final String USER_COLLEGE="user_college";

	public MySharedPreference(Context context){
		this.context=context;
		sharedpreferences = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
	}

	public void saveSharedPrefs(String user_id, String user_name, String user_email,String user_mobile,String user_degree,String user_college ){
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putString(USER_ID, user_id);
		editor.putString(USER_NAME, user_name);
		editor.putString(USER_EMAIL, user_email);
		editor.putString(USER_MOBILE,user_mobile);
		editor.putString(USER_DEGREE,user_degree);
		editor.putString(USER_COLLEGE,user_college);

		editor.apply();
	}

	public  String getPref(String key) {
		SharedPreferences preferences = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
		return preferences.getString(key, null);
	}

	public void clearSharedPrefs(){
		SharedPreferences sharedpreferences = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.clear();
		editor.apply();
	}

	public boolean checkSharedPrefs(String key){
		SharedPreferences sharedPrefs = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
		return sharedPrefs.contains(key);
	}

	public void saveUser(JSONObject user) {
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putString(USER_JSON, user.toString());
		editor.apply();
	}
}


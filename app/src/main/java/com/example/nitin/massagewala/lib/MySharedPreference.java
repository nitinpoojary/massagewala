package com.example.nitin.massagewala.lib;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by astiw on 09-11-2015.
 */
public class MySharedPreference {
    Context context;
    SharedPreferences sharedpreferences;
    public static final String USER_ID="user_id";
    public static final String USER_NAME ="user_name";
    public static final String USER_MOBILE ="user_mobile";
    public static final String USER_EMAIL ="user_email";
    public static final String USER_DEGREE="user_degree";
    public static final String USER_COLLEGE="user_college";

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

        editor.commit();
    }

    public  String getPref(String key) {
        SharedPreferences preferences = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    public void clearSharedPrefs(){
        SharedPreferences sharedpreferences = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    public boolean checkSharedPrefs(String key){
        SharedPreferences sharedPrefs = context.getSharedPreferences(Config.SP_FILE_NAME, Context.MODE_PRIVATE);
        if(sharedPrefs.contains(key)) {
            return true;
        }
        return false;
    }

}

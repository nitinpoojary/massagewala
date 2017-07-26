package com.example.nitin.massagewala.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by SIR.WilliamRamsay on 15-Jan-16.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance=null;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }

    public static MyApplication getsInstance() {
        return sInstance;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}

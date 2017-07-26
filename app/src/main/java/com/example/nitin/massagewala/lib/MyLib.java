package com.example.nitin.massagewala.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by astiw on 12-11-2015.
 */
public class MyLib {

    public static String remainingTime(Long timeInSeconds) {
        String result="";
        int days=(int) (timeInSeconds/(24*60*60));
        if(days>0)
        {
            timeInSeconds=timeInSeconds%(24*60*60);
            if(days==1)
                result+=days + " Day ";
            else
                result+=days + " Days ";
        }
        int hours=(int) (timeInSeconds/(60*60));
        if(hours>0)
        {
            timeInSeconds=timeInSeconds%(60*60);
            if(days==1)
                result+=hours + " Hour ";
            else
                result+=hours + " Hours ";
        }
        int minutes=(int) (timeInSeconds/(60));
        if(minutes>0)
        {
            timeInSeconds=timeInSeconds%(60);
            if(minutes==1)
                result+=minutes + " Minute ";
            else
                result+=minutes + " Minutes ";
        }
        if(timeInSeconds>0)
        {
            if(timeInSeconds==1)
                result+=timeInSeconds + " Second ";
            else
                result+=timeInSeconds + " Seconds ";
        }
        return  result;
    }
    public static String remainingTime(String strtimeInSeconds) {
        Long timeInSeconds=Long.parseLong(strtimeInSeconds);
        return remainingTime(timeInSeconds);
    }
    public static String remainingTime(int inttimeInSeconds) {
        return remainingTime((long) inttimeInSeconds);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=null;
        if(connectivityManager!=null)
            networkInfo=connectivityManager.getActiveNetworkInfo();
        else
            return false;

        if(networkInfo==null)
            return false;
        else
            return networkInfo.isConnected();
    }

    public static String nl2br(String str){
        return str.replace("\\n","<br />");
    }

}

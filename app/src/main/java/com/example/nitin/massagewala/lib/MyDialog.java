package com.example.nitin.massagewala.lib;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.nitin.massagewala.R;


/**
 * Created by astiw on 28-10-2015.
 */
public class MyDialog {
    public ProgressDialog progressDialog;
    public AlertDialog.Builder alertDialog;
    Context context;
    public boolean dialogResult=false;
    public MyDialog(Context context){
        this.context=context;
    }
    public void showProgress(String title, String message) {
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }
    public void showProgress(String title, String message, int icon) {

        progressDialog=new ProgressDialog(context);
        progressDialog.setIcon(icon);
        progressDialog.setMessage(message);
        if(title!=null){
            progressDialog.setTitle(title);
        }
        progressDialog.show();
    }

    public void hideProgress(){
        if(progressDialog.isShowing())
            progressDialog.cancel();
    }
    public void showAlertDialog(String title, String message){
        alertDialog=new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }
    public void showAlertDialog(String title, String message, int icon){
        alertDialog=new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setIcon(icon);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }
    public void showConfirmDialog(String title, String message, String positiveButton, String negativeButton){
        alertDialog=new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.icon_question);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogResult = true;
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogResult=false;
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

}

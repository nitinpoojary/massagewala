package com.example.nitin.massagewala.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nitin.massagewala.Fragment.HomeFragment;
import com.example.nitin.massagewala.Fragment.OilSelectionFragment;
import com.example.nitin.massagewala.R;
import com.example.nitin.massagewala.lib.Config;

public class MainActivity extends AppCompatActivity {
	//public static MainActivity mainActivity=new MainActivity();
	TextView textView;
	Typeface typeface;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = getFragmentManager().findFragmentByTag(HomeFragment.class.getName());
                    if(fragment instanceof HomeFragment){
                        Log.d(Config.TAG,"navigation_home in reload fragment");
                        loadFragment(fragment,false);
                    }else{
                        loadFragment(new HomeFragment(),true);
                    }
                    return true;
                case R.id.navigation_tracking:
                    fragment = getFragmentManager().findFragmentByTag(OilSelectionFragment.class.getName());
                    if(fragment instanceof OilSelectionFragment){
                        loadFragment(fragment,false);
                    }else{
                        loadFragment(new OilSelectionFragment(),true);
                    }
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_top);

		typeface = Typeface.createFromAsset(getAssets(),"fonts/Segoe UI Light.ttf");

		textView = (TextView) findViewById(R.id.tv_toolbarHead);
		textView.setTypeface(typeface);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		loadFragment(new HomeFragment(),true);
    }

    public void loadFragment(Fragment fragment,boolean flag) {
        if(flag){
            getFragmentManager().beginTransaction()
                    .replace(R.id.content, fragment,fragment.getClass().getName())
                    .addToBackStack(fragment.getClass().getName())
                    .commit();
        }
        else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Do you want to really exit");
            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        }
    }


}

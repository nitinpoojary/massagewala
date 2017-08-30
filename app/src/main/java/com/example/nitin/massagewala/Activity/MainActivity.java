package com.example.nitin.massagewala.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nitin.massagewala.Fragment.HomeFragment;
import com.example.nitin.massagewala.Fragment.OilSelectionFragment;
import com.example.nitin.massagewala.R;

public class MainActivity extends AppCompatActivity {
	//public static MainActivity mainActivity=new MainActivity();
	TextView textView;
	Typeface typeface;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_tracking:
					loadFragment(new OilSelectionFragment());
                    return true;
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
		loadFragment(new HomeFragment());
    }


	public void loadFragment(Fragment fragment) {
		getFragmentManager().beginTransaction()
				.replace(R.id.content, fragment)
				//.addToBackStack("demo")
				.commit();
	}

}

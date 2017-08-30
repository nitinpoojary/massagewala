package com.example.nitin.massagewala.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nitin.massagewala.R;

public class FirstScreen extends Activity implements View.OnClickListener {
	Button btn_signup,btn_register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*if (Build.VERSION.SDK_INT < 16) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}*/

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_first_screen);
		btn_signup=(Button)findViewById(R.id.btn_first_signin);
		btn_register=(Button)findViewById(R.id.btn_first_register);
		btn_signup.setOnClickListener(this);
		btn_register.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.btn_first_signin){
			startActivity(new Intent(this,LoginActivity.class));

		}else if (v.getId()==R.id.btn_first_register){
			startActivity(new Intent(this,RegistrationActivity.class));

		}
	}
}

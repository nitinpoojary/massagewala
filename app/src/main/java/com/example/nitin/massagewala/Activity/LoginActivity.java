package com.example.nitin.massagewala.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nitin.massagewala.R;
import com.example.nitin.massagewala.lib.Config;
import com.example.nitin.massagewala.lib.MyDialog;
import com.example.nitin.massagewala.lib.MyLib;
import com.example.nitin.massagewala.lib.MySharedPreference;
import com.example.nitin.massagewala.lib.MyValidator;
import com.example.nitin.massagewala.volley.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity implements View.OnClickListener {
	private EditText et_username, et_password;
	private TextView tv_forgotpassword, tv_signup;
	private Button btn_login;
	private RequestQueue requestQueue;
	private MyDialog myDialog;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login);
		init();
	}

	private void init() {

		Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Segoe UI Light.ttf");
		requestQueue= VolleySingleton.getsInstance().getmRequestQueue();
		et_username = (EditText) findViewById(R.id.et_login_username);
		et_username.setTypeface(typeface);
		et_password = (EditText) findViewById(R.id.et_login_passsword);
		et_password.setTypeface(typeface);
		tv_forgotpassword = (TextView) findViewById(R.id.tv_login_forgottonpassword);
		tv_signup = (TextView) findViewById(R.id.tv_login_singup);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		tv_forgotpassword.setOnClickListener(this);
		tv_signup.setOnClickListener(this);
		myDialog = new MyDialog(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn_login:
				if (MyLib.isOnline(this)) {
					if (ValidateFields()) {
						RequestLogin();
					}
				} else {
					Toast.makeText(this, R.string.network_problem, Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_login_forgottonpassword:
				Toast.makeText(this, "forgot password", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tv_login_singup:
				Toast.makeText(this, "sign up  ", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(this,RegistrationActivity.class));
				break;
		}
	}

	private boolean ValidateFields() {
		return MyValidator.isValidField(et_username) && MyValidator.isValidPassword(et_password);
	}

	private void RequestLogin() {
		myDialog.showProgress("Login..", getString(R.string.loading));
		StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.JSON_URL + "login", new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					Log.d(Config.TAG, response);
					myDialog.hideProgress();
					JSONObject jsonObject = new JSONObject(response);
					if (jsonObject.getBoolean("result")) {
						MySharedPreference mySharedPreference = new MySharedPreference(LoginActivity.this);
						mySharedPreference.saveUser(jsonObject.getJSONObject("user"));

						startActivity(new Intent(LoginActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
						finish();
					} else {
						Toast.makeText(LoginActivity.this, "Invalied Username And Password", Toast.LENGTH_SHORT).show();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				myDialog.hideProgress();
			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> params = new HashMap<>();
				params.put("username", et_username.getText().toString());
				params.put("password", et_password.getText().toString());
				params.put("notification_token", "");
				return params;
			}
		};
		requestQueue.add(stringRequest);
	}

}


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
import com.example.nitin.massagewala.lib.MyValidator;
import com.example.nitin.massagewala.volley.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends Activity implements View.OnClickListener {
	EditText et_email, et_number, et_username, et_password;
	Button btn_createaccount;
	TextView tv_alreadyhaveac;
	RequestQueue requestQueue;
	String URL = Config.JSON_URL + "register";
	private final String TAG = "tag Registration";
	MyDialog myDialog;
	public static Typeface typeface;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_registration);

		init();
	}

	private void init() {


		typeface = Typeface.createFromAsset(getAssets(),"fonts/Segoe UI Light.ttf");

		requestQueue = VolleySingleton.getsInstance().getmRequestQueue();
		myDialog = new MyDialog(this);
		et_email = (EditText) findViewById(R.id.et_registration_email);
		et_email.setTypeface(typeface);
		et_number = (EditText) findViewById(R.id.et_registration_number);
		et_number.setTypeface(typeface);
		et_username = (EditText) findViewById(R.id.et_registration_username);
		et_username.setTypeface(typeface);
		et_password = (EditText) findViewById(R.id.et_registration_password);
		et_password.setTypeface(typeface);
		btn_createaccount = (Button) findViewById(R.id.btn_registration_createaccount);
		btn_createaccount.setOnClickListener(this);
		tv_alreadyhaveac = (TextView) findViewById(R.id.tv_registration_alreadyhaveaccount);
		tv_alreadyhaveac.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_registration_createaccount) {
			if (MyLib.isOnline(this)) {
				if (ValidateFields()) {
					//calling api
					RegistrationRequest();
				}
			} else {
				Toast.makeText(this, R.string.network_problem, Toast.LENGTH_SHORT).show();
			}


		} else if (v.getId() == R.id.tv_registration_alreadyhaveaccount) {
			finish();
		}

	}

	// hitting theregistration request
	private void RegistrationRequest() {
		myDialog.showProgress("Registration",getString(R.string.loading));
		StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				myDialog.hideProgress();
				Log.d(TAG, "Response =" + response);
				try {
					JSONObject jsonObject = new JSONObject(response);
					if (jsonObject.getBoolean("result")) {
						startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
						finish();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				myDialog.hideProgress();
				Log.d(TAG, "Error =" + error);
				error.printStackTrace();
			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> parms = new HashMap<>();
				parms.put("email", et_email.getText().toString());
				parms.put("password", et_password.getText().toString());
				parms.put("mobile", et_number.getText().toString());
				parms.put("username", et_username.getText().toString());
				return parms;
			}
		};
		requestQueue.add(stringRequest);
	}

	// validating text fields

	private boolean ValidateFields() {
		Boolean result = true;
		if (!MyValidator.isValidEmail(et_email)) {
			result = false;
		}
		if (!MyValidator.isValidMobile(et_number)) {
			result = false;
		}
		if (!MyValidator.isValidPassword(et_password)) {
			result = false;
		}
		if (!MyValidator.isValidField(et_username)) {
			result = false;
		}

		return result;
	}
}

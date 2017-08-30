package com.example.nitin.massagewala.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nitin.massagewala.R;
import com.example.nitin.massagewala.lib.Config;
import com.example.nitin.massagewala.volley.VolleySingleton;

public class LoginActivity extends Activity implements View.OnClickListener {
    EditText et_username, et_password;
    TextView tv_forgotpassword, tv_signup;
    Button btn_login;
	RequestQueue requestQueue;

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
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
            	/*Toast.makeText(this, "button is clicked", Toast.LENGTH_SHORT).show();
				if (MyLib.isOnline(this)) {
					if (ValidateFields()) {
						//calling api
						RequestLogin();
					}
				} else {
					Toast.makeText(this, R.string.network_problem, Toast.LENGTH_SHORT).show();
				}*/

            	startActivity(new Intent(this,MainActivity.class));
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
		Boolean result=true;

		return false;
	}

	private void RequestLogin() {
		StringRequest stringRequest=new StringRequest(Config.JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
		requestQueue.add(stringRequest);
	}
}

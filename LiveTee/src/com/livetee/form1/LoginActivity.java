package com.livetee.form1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
	EditText userID, password;
	Button loginButton;
	CustomApplication app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		userID = (EditText) findViewById(R.id.Username);
		password = (EditText) findViewById(R.id.Password);
		loginButton = (Button) findViewById(R.id.LoginButton);
		app = ((CustomApplication) getApplication());
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * if ((userID.getText().toString().trim().equals("user")) &&
				 * (password.getText().toString().trim() .equals("password"))) {
				 */
				Intent formList = new Intent();
				formList.setClass(getApplicationContext(),
						UserFormListActivity.class);
				formList.putExtra("username", userID.getText().toString());
				app.getFormData().setUserID( userID.getText().toString());
				startActivity(formList);
				/*
				 * } else { userID.setText(""); password.setText(""); Toast
				 * toast = Toast.makeText(getApplicationContext(),
				 * "invalid username or passowrd", Toast.LENGTH_SHORT);
				 * toast.setGravity(0, 0, 0); toast.show(); }
				 */}
		});

	}
}
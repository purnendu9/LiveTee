package com.livetee.form1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Form1Page1 extends Activity {
	CustomApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1page1);
		app = ((CustomApplication) getApplication());
		Button iAgreeButton = (Button) findViewById(R.id.agree);
		iAgreeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent();
				nextPage.setClass(getApplicationContext(), Form1Page2.class);
				app.getFormData().clearFormData();
				startActivity(nextPage);
			}
		});
	}

}

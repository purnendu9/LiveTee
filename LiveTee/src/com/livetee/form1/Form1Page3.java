package com.livetee.form1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Form1Page3 extends Activity {
	
	EditText editText9;
	EditText editText10;
	EditText editText11;
	EditText editText12;
	EditText editText13;
	EditText editText14;
	EditText editText15;
	String page3Answer = "";
	CustomApplication app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1page3);
		editText9 = (EditText) findViewById(R.id.editText9);
		editText10 = (EditText) findViewById(R.id.editText10);
		editText11 = (EditText) findViewById(R.id.editText11);
		editText12 = (EditText) findViewById(R.id.editText12);
		editText13 = (EditText) findViewById(R.id.editText13);
		editText14 = (EditText) findViewById(R.id.editText14);
		editText15 = (EditText) findViewById(R.id.editText15);
		app = ((CustomApplication) getApplication());
		if (!"".equalsIgnoreCase(app.getFormData().page3Answers)) {
			String[] answer;
			answer = app.getFormData().page3Answers.split("~");
			editText9.setText(answer[0]);
			editText10.setText(answer[1]);
			editText11.setText(answer[2]);
			editText12.setText(answer[3]);
			editText13.setText(answer[4]);
			editText14.setText(answer[5]);
			editText15.setText(answer[6]);
		}
		Button nextButton = (Button) findViewById(R.id.next);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent();
				nextPage.setClass(getApplicationContext(), Form1Page4.class);
				page3Answer = editText9.getText().toString().trim() + "~"
						+ editText10.getText().toString().trim() + "~"
						+ editText11.getText().toString().trim() + "~"
						+ editText12.getText().toString().trim() + "~"
						+ editText13.getText().toString().trim() + "~"
						+ editText14.getText().toString().trim() + "~"
						+ editText15.getText().toString().trim() + "~";
				app.getFormData().page3Answers = page3Answer;
				startActivity(nextPage);
			}
		});
		Button previousButton = (Button) findViewById(R.id.previous);
		previousButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent();
				nextPage.setClass(getApplicationContext(), Form1Page2.class);
				page3Answer = editText9.getText().toString().trim() + "~"
						+ editText10.getText().toString().trim() + "~"
						+ editText11.getText().toString().trim() + "~"
						+ editText12.getText().toString().trim() + "~"
						+ editText13.getText().toString().trim() + "~"
						+ editText14.getText().toString().trim() + "~"
						+ editText15.getText().toString().trim() + "~";
				app.getFormData().page3Answers = page3Answer;
				startActivity(nextPage);
			}
		});
	}

}

package com.livetee.form1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Form1Page4 extends Activity {
	EditText editText16;
	EditText editText17;
	EditText editText18;
	EditText editText19;
	EditText editText20;
	EditText editText21;
	String page4Answer = "";
	CustomApplication app;
	String finaldata;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1page4);
		editText16 = (EditText) findViewById(R.id.editText16);
		editText17 = (EditText) findViewById(R.id.editText17);
		editText18 = (EditText) findViewById(R.id.editText18);
		editText19 = (EditText) findViewById(R.id.editText19);
		editText20 = (EditText) findViewById(R.id.editText20);
		editText21 = (EditText) findViewById(R.id.editText21);
		app = ((CustomApplication) getApplication());
		if (!"".equalsIgnoreCase(app.getFormData().page4Answers)) {
			String[] answer;
			answer = app.getFormData().page4Answers.split("~");
			editText16.setText(answer[0]);
			editText17.setText(answer[1]);
			editText18.setText(answer[2]);
			editText19.setText(answer[3]);
			editText20.setText(answer[4]);
			editText21.setText(answer[5]);
		}
		Button previousButton = (Button) findViewById(R.id.previous);
		previousButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent();
				nextPage.setClass(getApplicationContext(), Form1Page3.class);
				page4Answer = editText16.getText().toString().trim() + "~"
						+ editText17.getText().toString().trim() + "~"
						+ editText18.getText().toString().trim() + "~"
						+ editText19.getText().toString().trim() + "~"
						+ editText20.getText().toString().trim() + "~"
						+ editText21.getText().toString().trim();
				app.getFormData().page4Answers = page4Answer;
				startActivity(nextPage);
			}
		});
		Button submitButton = (Button) findViewById(R.id.submit);
		submitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page4Answer = editText16.getText().toString().trim() + "~"
						+ editText17.getText().toString().trim() + "~"
						+ editText18.getText().toString().trim() + "~"
						+ editText19.getText().toString().trim() + "~"
						+ editText20.getText().toString().trim() + "~"
						+ editText21.getText().toString().trim();
				app.getFormData().page4Answers = page4Answer;
				finaldata = app.getFormData().page2Answers
						+ app.getFormData().page3Answers
						+ app.getFormData().page4Answers;
				try {
					Datasource.saveFormData(finaldata, app.getFormData()
							.getUserID());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}

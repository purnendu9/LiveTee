package com.livetee.form1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Form1Page2 extends Activity {
	EditText editText1;
	EditText editText2;
	EditText editText3;
	EditText editText4;
	EditText editText5;
	EditText editText6;
	EditText editText7;
	EditText editText8;
	String page2Answer = "";
	CustomApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form1page2);
		app = ((CustomApplication) getApplication());
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		editText5 = (EditText) findViewById(R.id.editText5);
		editText6 = (EditText) findViewById(R.id.editText6);
		editText7 = (EditText) findViewById(R.id.editText7);
		editText8 = (EditText) findViewById(R.id.editText8);
		if (!"".equalsIgnoreCase(app.getFormData().page2Answers)) {
			String[] answer;
			answer = app.getFormData().page2Answers.split("~");
			editText1.setText(answer[0]);
			editText2.setText(answer[1]);
			editText3.setText(answer[2]);
			editText4.setText(answer[3]);
			editText5.setText(answer[4]);
			editText6.setText(answer[5]);
			editText7.setText(answer[6]);
			editText8.setText(answer[7]);
		}
		Button nextButton = (Button) findViewById(R.id.next);
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent();
				page2Answer = editText1.getText().toString().trim() + "~"
						+ editText2.getText().toString().trim() + "~"
						+ editText3.getText().toString().trim() + "~"
						+ editText4.getText().toString().trim() + "~"
						+ editText5.getText().toString().trim() + "~"
						+ editText6.getText().toString().trim() + "~"
						+ editText7.getText().toString().trim() + "~"
						+ editText8.getText().toString().trim() + "~";
				app.getFormData().page2Answers = page2Answer;
				nextPage.setClass(getApplicationContext(), Form1Page3.class);
				startActivity(nextPage);
			}
		});

	}
}

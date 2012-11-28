package com.livetee.form1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class UserFormReview extends Activity {
	EditText editText1;
	EditText editText2;
	EditText editText3;
	EditText editText4;
	EditText editText5;
	EditText editText6;
	EditText editText7;
	EditText editText8;
	EditText editText9;
	EditText editText10;
	EditText editText11;
	EditText editText12;
	EditText editText13;
	EditText editText14;
	EditText editText15;
	EditText editText16;
	EditText editText17;
	EditText editText18;
	EditText editText19;
	EditText editText20;
	EditText editText21;
	String page2Answer = "";
	CustomApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formreview);
		app = ((CustomApplication) getApplication());
		Bundle extras = getIntent().getExtras();
		String formID = extras.getString("formID");
		String formDataForID = Datasource.getFormDataForID(formID);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		editText5 = (EditText) findViewById(R.id.editText5);
		editText6 = (EditText) findViewById(R.id.editText6);
		editText7 = (EditText) findViewById(R.id.editText7);
		editText8 = (EditText) findViewById(R.id.editText8);
		editText9 = (EditText) findViewById(R.id.editText9);
		editText10 = (EditText) findViewById(R.id.editText10);
		editText11 = (EditText) findViewById(R.id.editText11);
		editText12 = (EditText) findViewById(R.id.editText12);
		editText13 = (EditText) findViewById(R.id.editText13);
		editText14 = (EditText) findViewById(R.id.editText14);
		editText15 = (EditText) findViewById(R.id.editText15);
		editText16 = (EditText) findViewById(R.id.editText16);
		editText17 = (EditText) findViewById(R.id.editText17);
		editText18 = (EditText) findViewById(R.id.editText18);
		editText19 = (EditText) findViewById(R.id.editText19);
		editText20 = (EditText) findViewById(R.id.editText20);
		editText21 = (EditText) findViewById(R.id.editText21);
		if (!"".equalsIgnoreCase(formDataForID)) {
			String[] answer;
			answer = formDataForID.split("~");
			if (answer.length < 21) {

			} else {
				editText1.setText(answer[0]);
				editText2.setText(answer[1]);
				editText3.setText(answer[2]);
				editText4.setText(answer[3]);
				editText5.setText(answer[4]);
				editText6.setText(answer[5]);
				editText7.setText(answer[6]);
				editText8.setText(answer[7]);
				editText9.setText(answer[8]);
				editText10.setText(answer[9]);
				editText11.setText(answer[10]);
				editText12.setText(answer[11]);
				editText13.setText(answer[12]);
				editText14.setText(answer[13]);
				editText15.setText(answer[14]);
				editText16.setText(answer[15]);
				editText17.setText(answer[16]);
				editText18.setText(answer[17]);
				editText19.setText(answer[18]);
				editText20.setText(answer[19]);
				editText21.setText(answer[20]);
			}
		}
	}
}

package com.livetee.form1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class UserFormListActivity extends Activity {
	Button createNewForm;
	String listItems;
	String[] forms;
	CustomApplication app;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Bundle extras = getIntent().getExtras(); 
		String userName = extras.getString("username"); 
		setContentView(R.layout.userformlist);
		app = ((CustomApplication) getApplication());
		ListView listview = (ListView) findViewById(R.id.listView1);
		createNewForm = (Button) findViewById(R.id.CreateNew);
		try {
			listItems = Datasource.getListOfForms(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] listcontent = listItems.split("~");

		forms = new String[listcontent.length];
		for (int i = 0; i < listcontent.length; i++) {
			forms[i] = listcontent[i];
		}
		ItemsAdapter itemsAdapter = new ItemsAdapter(UserFormListActivity.this,
				R.layout.list, forms);
		listview.setAdapter(itemsAdapter);
		createNewForm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent questionsIntent = new Intent();
				questionsIntent.setClass(getApplicationContext(),
						Form1Page1.class);
				app.getFormData().clearFormData();
				startActivity(questionsIntent);
			}
		});

	}

}

class ItemsAdapter extends BaseAdapter {
	String[] items;
	Context context;

	public ItemsAdapter(Context context, int textViewResourceId, String[] items) {
		this.items = items;
		this.context = context;
	}

	public int getCount() {
		return items.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LinearLayout l;
		TextView tv = null;
		Button b1, b2;
		View v1;
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100, 0);
		l = new LinearLayout(context);
		tv = new TextView(context);
		v1 = new View(context);
		l.setPadding(10, 0, 10, 0);
		v1.setLayoutParams(params);
		l.addView(tv);
		l.addView(v1);
		// l.setBackgroundColor(Color.LTGRAY);
		b1 = new Button(context);
		b2 = new Button(context);
		b2.setTag(items[position]);
		b1.setText("Delete");
		b2.setText("Review");
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View buttonReview) {
				Intent reviewIntent = new Intent();
				reviewIntent.setClass(context,
						UserFormReview.class);
				reviewIntent.putExtra("formID",(String) buttonReview.getTag());
				context.startActivity(reviewIntent);
			}
		});
		l.addView(b1);
		l.addView(b2);
		tv.setText("Form # " + items[position]);
		return l;

	}
}

package com.example.fragmentsample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity{

	public static final String EXTRA_URL = "url";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			finish();
			return;
		}
		
		setContentView(R.layout.detail);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			String s = extras.getString(EXTRA_URL);
			TextView view = (TextView)findViewById(R.id.detail_text);
			view.setText(s);
		}
	}
}

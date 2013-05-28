package com.example.fragmentsample;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onMyItemSelected(String link){
    	DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detailFragment);
    	if(fragment != null && fragment.isInLayout()){
    		fragment.setText(link);
    	}
    }
    
}
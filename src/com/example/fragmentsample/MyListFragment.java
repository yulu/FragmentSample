package com.example.fragmentsample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment{
	
	private OnItemSelectedListener listener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragment_list, container, false);
		Button button = (Button)view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail();
				
			}
		});
		
		return view;
	}
	
	public interface OnItemSelectedListener{
		public void onMyItemSelected(String link);
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		if(activity instanceof OnItemSelectedListener){
			listener = (OnItemSelectedListener)activity;
		}else{
			throw new ClassCastException(activity.toString()
					+ " must implement MyListFragment.OnItemSelectedListener");
		}
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		listener = null;
	}
	
	//May also be triggered from the Activity
	public void updateDetail(){
		//create a string, just for testing
		String newTime = String.valueOf(System.currentTimeMillis());
		
		listener.onMyItemSelected(newTime);
	}
}

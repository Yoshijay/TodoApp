
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		splash_screen
	 *	@date 		Thursday 06th of June 2024 06:16:33 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.remedyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen_activity extends Activity {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);


		

	new Handler().postDelayed(new Runnable() {
		@Override
		public void run() {
			Intent intent=new Intent(splash_screen_activity.this, intro_activity.class);
				startActivity(intent);
				finish();
		}
	},2000);
	}
}
	
	
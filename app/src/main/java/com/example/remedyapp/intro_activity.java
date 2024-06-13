
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		intro
	 *	@date 		Friday 07th of June 2024 01:20:37 AM
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


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class intro_activity extends Activity {

	

	private Button get_started;
	private TextView txt_lbl_qut_login;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		txt_lbl_qut_login = (TextView) findViewById(R.id.txt_lbl_qut_login);


		get_started=findViewById(R.id.btn_get_started);
		get_started.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(intro_activity.this, sign_up_activity.class);
				startActivity(intent);
			}
		});

		txt_lbl_qut_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(intro_activity.this, sign_in_activity.class);
				startActivity(intent);
			}
		});
	
		
		//custom code goes here
	
	}
}
	
	

	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		user_info
	 *	@date 		Friday 07th of June 2024 01:08:45 AM
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
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

	public class user_info_activity extends Activity {


	private TextView txt_user_name,txt_email;




	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_info);

		Intent intent = getIntent();


		String user_email = intent.getStringExtra("email");
		String user_password=intent.getStringExtra("password");
		UserModel userModel=new UserModel(user_email,user_password);



		txt_user_name = (TextView) findViewById(R.id.txt_user_name);

		txt_email = (TextView) findViewById(R.id.txt_email);

	
		
		//custom code goes here
UserModel user_info=new UserModel();
DataBaseHelper dataBaseHelper=new DataBaseHelper(user_info_activity.this);
		user_info=dataBaseHelper.getUserInfo(userModel);
		txt_user_name.setText(user_info.getUser_name());

	}

	public void getUserInfor(){

	}
}
	
	
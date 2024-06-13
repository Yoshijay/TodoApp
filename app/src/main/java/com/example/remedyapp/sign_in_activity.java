
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		sign_in
	 *	@date 		Wednesday 05th of June 2024 09:50:32 AM
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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

	public class sign_in_activity extends Activity {

	

	private TextView txt_link_to_signup,email,password,txt_msg;


	private Button btn_signin;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in);

		txt_link_to_signup = (TextView) findViewById(R.id.txt_link_to_signup);
		email = (TextView) findViewById(R.id.email);
		password = (TextView) findViewById(R.id.password);
		txt_msg=findViewById(R.id.txt_msg);
		btn_signin=findViewById(R.id.btn_signin);
		btn_signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				UserModel userModel;
				try {
					userModel = new UserModel(email.getText().toString(), password.getText().toString());

					DataBaseHelper dataBaseHelper = new DataBaseHelper(sign_in_activity.this);
					boolean result= dataBaseHelper.Login(userModel);
					if(result==true)
					{
						Intent intent=new Intent(sign_in_activity.this, NavigationActivity.class);
						intent.putExtra("email", email.getText().toString());
						intent.putExtra("password", password.getText().toString());
						startActivity(intent);
					}else{
						Toast.makeText(sign_in_activity.this, "Email or password is incorrect!", Toast.LENGTH_SHORT).show();
					}

				}catch (Exception e){

				}
			}
		});

		txt_link_to_signup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(sign_in_activity.this, sign_up_activity.class);
				startActivity(intent);
			}
		});
		

	
	}

		@Override
		public void onBackPressed() {
//			super.onBackPressed();
		}
	}
	
	
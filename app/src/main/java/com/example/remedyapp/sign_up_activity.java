
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		sign_up
	 *	@date 		Wednesday 05th of June 2024 06:02:07 AM
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

	public class sign_up_activity extends Activity {

	
	private View _bg__sign_up_ek2;
	private View rectangle_4;
	private ImageView rectangle_6;
	private TextView i_agree_to_terms_and_conditions;
	private ImageView vector;
	private ImageView vector_ek1;
	private View rectangle_3;
	private TextView confirm_password;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private View rectangle_3_ek1;
	private TextView password;
	private View rectangle_3_ek2;
	private TextView email;
	private ImageView vector_ek4;
	private ImageView vector_ek5;
	private View rectangle_3_ek3;
	private TextView phone_number;
	private ImageView vector_ek6;
	private ImageView vector_10;
	private View rectangle_3_ek4;
	private TextView gender;
	private ImageView vector_ek7;
	private View rectangle_3_ek5;
	private TextView age;
	private ImageView vector_ek8;
	private View rectangle_3_ek6;
	private TextView your_name;
	private ImageView image_14;
	private ImageView battery_level;
	private TextView _5_40;
	private ImageView vector_ek9;
	private ImageView vector_ek10;
	private View rectangle_2;
	private TextView already_have_an_account__login;
	private TextView create_a_new_account;
	private TextView or;
	private TextView sign_up_ek3;
	private ImageView image_13;
	private ImageView image_14_ek1;
	private ImageView image_15;
	private TextView label_text;
	private Spinner gender_spinnder;
	private CheckBox agree_checkbox;
	private Button btn_create_account;
	private String gender_val="";
	private boolean is_agree=false;

		String[] gender_array = { "Male", "Female"};
		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);

		agree_checkbox=(CheckBox) findViewById(R.id.agree_checkbox);
		gender_spinnder=(Spinner) findViewById(R.id.gender);

		rectangle_4 = (View) findViewById(R.id.rectangle_4);

		confirm_password = (EditText) findViewById(R.id.confirm_password);


		password = (EditText) findViewById(R.id.password);

		email = (EditText) findViewById(R.id.email);

		phone_number = (EditText) findViewById(R.id.phone_number);

		age = (EditText) findViewById(R.id.age);

		your_name = (EditText) findViewById(R.id.your_name);
		image_14 = (ImageView) findViewById(R.id.image_14);

		already_have_an_account__login = (TextView) findViewById(R.id.already_have_an_account__login);
		create_a_new_account = (TextView) findViewById(R.id.create_a_new_account);
		or = (TextView) findViewById(R.id.or);
		sign_up_ek3 = (TextView) findViewById(R.id.sign_up_ek3);
		image_13 = (ImageView) findViewById(R.id.image_13);
		image_14_ek1 = (ImageView) findViewById(R.id.image_14_ek1);
		image_15 = (ImageView) findViewById(R.id.image_15);


//			confirm_password.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					if(password)
//				}
//			});

			already_have_an_account__login.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent=new Intent(sign_up_activity.this, sign_in_activity.class);
					startActivity(intent);
				}
			});

			agree_checkbox.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					boolean checked = ((CheckBox) view).isChecked();
					// Check which checkbox was clicked
					if (checked){
						is_agree=true;
					}
					else{
						is_agree=false;
					}
				}
			});

			ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender_array);
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			//Setting the ArrayAdapter data on the Spinner
			gender_spinnder.setAdapter(aa);

			gender_spinnder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
					gender_val=gender_array[i];

				}

				@Override
				public void onNothingSelected(AdapterView<?> adapterView) {

				}
			});

			btn_create_account=findViewById(R.id.btn_create_account);

		btn_create_account.setOnClickListener(new View.OnClickListener() {

			
			@Override
			public void onClick(View view) {

				if(is_agree==false){

					Toast.makeText(sign_up_activity.this, "Please select the agreement checkbox!", Toast.LENGTH_SHORT).show();


				}else if (!your_name.getText().toString().trim().isEmpty() && !age.getText().toString().trim().isEmpty()&&!phone_number.getText().toString().trim().isEmpty()&&!email.getText().toString().trim().isEmpty()&&!password.getText().toString().trim().isEmpty() ) {
					String passwordText = password.getText().toString().trim();
					String confirmPasswordText = confirm_password.getText().toString().trim();
					if(!passwordText.equals(confirmPasswordText)){
						Toast.makeText(sign_up_activity.this, "Confirm Password doesn't match Password !", Toast.LENGTH_SHORT).show();
					}else{

						UserModel userModel;
						try {
							userModel = new UserModel(your_name.getText().toString(), Integer.parseInt(age.getText().toString()), gender_val, phone_number.getText().toString(), email.getText().toString(), password.getText().toString());

							DataBaseHelper dataBaseHelper = new DataBaseHelper(sign_up_activity.this);
							boolean success = dataBaseHelper.addOne(userModel);
							if(success==true){
								Intent intent=new Intent(sign_up_activity.this, NavigationActivity.class);
								intent.putExtra("email", email.getText().toString());
								intent.putExtra("password", password.getText().toString());
								startActivity(intent);
							}

						}catch (Exception e){

						}
					}


				}else{
					Toast.makeText(sign_up_activity.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
				}

			}
		});

	
	}
}
	
	
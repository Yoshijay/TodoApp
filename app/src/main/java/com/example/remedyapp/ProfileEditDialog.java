package com.example.remedyapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ProfileEditDialog extends Dialog {
    private String user_name,email,contact_no;
    private int age,user_id;
    public ProfileEditDialog(@NonNull Context context,int user_id,String user_name,int age,String email,String contact_no) {
        super(context);
        this.user_id=user_id;
        this.user_name=user_name;
        this.age=age;
        this.email=email;
        this.contact_no=contact_no;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit_dialog);

        TextView text_username=findViewById(R.id.txt_edit_name);
        TextView txt_age=findViewById(R.id.txt_edit_age);
        TextView txt_email=findViewById(R.id.txt_edit_email);
        TextView txt_contact=findViewById(R.id.txt_edit_contact);
//
        text_username.setText(user_name);
        txt_age.setText(String.valueOf(age));
        txt_email.setText(email);
        txt_contact.setText(contact_no);

        ImageButton edit_profile_close=findViewById(R.id.edit_profile_close);
        edit_profile_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button btn_save_edit_profile=findViewById(R.id.btn_save_edit_profile);
        btn_save_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DataBaseHelper dataBaseHelper=new DataBaseHelper(getContext());
                    UserModel userModel=new UserModel();
                    userModel.setId(user_id);
                    userModel.setUser_name(text_username.getText().toString());
                    userModel.setAge(Integer.parseInt(txt_age.getText().toString()));
                    userModel.setPhone(txt_contact.getText().toString());
                    userModel.setEmail(txt_email.getText().toString());

                    dataBaseHelper.updateUserInfo(userModel);
                    dismiss();

            }
        });
    }
}

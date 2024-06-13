package com.example.remedyapp.ui.gallery;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.remedyapp.DataBaseHelper;
import com.example.remedyapp.ProfileEditDialog;
import com.example.remedyapp.R;
import com.example.remedyapp.TaskDeleteDialog;
import com.example.remedyapp.UserModel;
import com.example.remedyapp.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private Button btn_edit_profile;
    private TextView txt_user_name,txt_phone_no,txt_email,txt_age;
    private int user_id=0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

         txt_user_name=binding.txtName;
        txt_phone_no=binding.txtPhoneNo;
        txt_email=binding.txtEmail;
        txt_age=binding.txtAge;
        btn_edit_profile=binding.btnEditProfile;

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UserModel userModel=new UserModel();
                ProfileEditDialog profileEditDialog=new ProfileEditDialog(getContext(),user_id,txt_user_name.getText().toString(),Integer.parseInt(txt_age.getText().toString()),txt_email.getText().toString(),txt_phone_no.getText().toString());
                profileEditDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                profileEditDialog.setContentView(R.layout.profile_edit_dialog);
                Window help_window = profileEditDialog.getWindow();
                help_window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
                profileEditDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                profileEditDialog.setCanceledOnTouchOutside(false);
                profileEditDialog.show();
            }
        });

//        Intent intent = getIntent();
//
//
//        String user_email = intent.getStringExtra("email");
//        String user_password=intent.getStringExtra("password");
//        UserModel userModel=new UserModel(user_email,user_password);
//
//        UserModel user_info=new UserModel();
//        DataBaseHelper dataBaseHelper=new DataBaseHelper(getContext());
//        user_info=dataBaseHelper.getUserInfo(userModel);
//        txt_user_name.setText(user_info.getUser_name());

//    }
//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String user_email = getArguments().getString("user_email");
            String user_password = getArguments().getString("user_password");

            UserModel userModel=new UserModel(user_email,user_password);


            DataBaseHelper dataBaseHelper=new DataBaseHelper(getContext());

            UserModel return_data_userModel=dataBaseHelper.getUserInfo(userModel);
            user_id=return_data_userModel.getId();
            txt_age.setText(String.valueOf(return_data_userModel.getAge()));
             txt_user_name.setText(return_data_userModel.getUser_name());
            txt_phone_no.setText(return_data_userModel.getPhone());
            txt_email.setText(return_data_userModel.getEmail());
            // Use the user_email and user_password as needed
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
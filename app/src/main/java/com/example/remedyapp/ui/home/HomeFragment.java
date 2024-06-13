package com.example.remedyapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.remedyapp.DataBaseHelper;
import com.example.remedyapp.ListActivity;
import com.example.remedyapp.R;
import com.example.remedyapp.UserModel;
import com.example.remedyapp.databinding.FragmentHomeBinding;
import com.example.remedyapp.intro_activity;
import com.example.remedyapp.splash_screen_activity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private String user_name;
    private TextView txt_hello;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final View rectangle29=binding.rectangle29;



         txt_hello=binding.helloJimin;





        rectangle29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
            }
        });
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

            txt_hello.setText("Hello"+" "+return_data_userModel.getUser_name()+"!");

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
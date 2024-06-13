package com.example.remedyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ListActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<TaskModel> models;
    private CustomeListAdapter adapter;
    private Button btn_add_task;
    private TextView txt_task;
//    private ImageButton list_item_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        listview=(ListView) findViewById(R.id.listView);
        btn_add_task=findViewById(R.id.btn_add_task);
        txt_task=findViewById(R.id.txt_task);


        btn_add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskModel taskModel;
                try {
//                    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                    if(!txt_task.getText().toString().isEmpty()){
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/YYYY hh:mm:a");
                        String strDate = sdf.format(c.getTime());
                        taskModel = new TaskModel(txt_task.getText().toString(),strDate);

                        DataBaseHelper dataBaseHelper = new DataBaseHelper(ListActivity.this);
                        boolean success = dataBaseHelper.addTask(taskModel);
                        if(success==true){
                            LoadList();
                            txt_task.setText("");
//
                        }
                    }

//						Toast.makeText(sign_up_activity.this, "sucsess"+success, Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });

        LoadList();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void LoadList(){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(ListActivity.this);
        models=dataBaseHelper.getTasks();

        adapter=new CustomeListAdapter(ListActivity.this,models);
        listview.setAdapter(adapter);

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LoadList();
    }
}
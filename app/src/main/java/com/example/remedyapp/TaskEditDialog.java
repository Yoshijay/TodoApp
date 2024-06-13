package com.example.remedyapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TaskEditDialog extends Dialog {

    private Context context;
    private String task;
    private int task_id;

    public TaskEditDialog(@NonNull Context context,String task,int task_id) {
        super(context, R.style.NoActionBarDialog);
        this.context = context;
        this.task=task;
        this.task_id=task_id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_edit_dialog);

        TextView textTask = findViewById(R.id.txt_p);
        textTask.setText(this.task);

        ImageButton btn_close=findViewById(R.id.edit_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Button edit_save=findViewById(R.id.btn_save_edit);
        edit_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskModel taskModel=new TaskModel();
                taskModel.setId(task_id);
                taskModel.setTask(textTask.getText().toString());
                DataBaseHelper dataBaseHelper=new DataBaseHelper(context);
                dataBaseHelper.updateTask(taskModel);

                dismiss();

            }
        });


        //find your views like this and use them as you want

    }

    @Override
    public void onBackPressed() {
        //do nothing <----- only this if you want to forbid the user to exit the dialog with the back button, else don't override this method
    }
}
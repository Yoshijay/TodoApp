package com.example.remedyapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class TaskDeleteDialog extends Dialog {

    private Context context;

    private int task_id;
    public TaskDeleteDialog(@NonNull Context context,int task_id) {
        super(context,R.style.NoActionBarDialog);
        this.context=context;
        this.task_id=task_id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_delete_confirm_dailog);

        Button btn_yes=findViewById(R.id.btn_yes);
        Button btn_no=findViewById(R.id.btn_no);
        ImageButton del_close=findViewById(R.id.btn_del_close);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TaskModel taskModel=new TaskModel();
                taskModel.setId(task_id);

                DataBaseHelper dataBaseHelper=new DataBaseHelper(context);
                dataBaseHelper.deleteTask(taskModel);
                dismiss();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        del_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //do nothing <----- only this if you want to forbid the user to exit the dialog with the back button, else don't override this method
    }
}

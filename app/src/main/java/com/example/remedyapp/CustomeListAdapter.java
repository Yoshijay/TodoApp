package com.example.remedyapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomeListAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<TaskModel> models;
    public CustomeListAdapter(Context context, ArrayList<TaskModel> models) {
        this.context = context;
        this.models = models;
    }




    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=View.inflate(context,R.layout.list_item,null);
        }
        TextView task=view.findViewById(R.id.txt_task);
        TaskModel model=models.get(i);
        task.setText(model.getTask());
        TextView date=view.findViewById(R.id.date);
        date.setText(model.getDate());

       ImageButton list_item_edit=(ImageButton)view.findViewById(R.id.btn_list_item_edit);
        list_item_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskEditDialog dialog = new TaskEditDialog(context,model.getTask(),model.getId());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.task_edit_dialog);
                Window help_window = dialog.getWindow();
                help_window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
        });

        ImageButton btn_list_item_delete=view.findViewById(R.id.btn_list_item_delete);

        btn_list_item_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskDeleteDialog taskDeleteDialog=new TaskDeleteDialog(context,model.getId());
                taskDeleteDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                taskDeleteDialog.setContentView(R.layout.task_delete_confirm_dailog);
                Window help_window = taskDeleteDialog.getWindow();
                help_window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
                taskDeleteDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                taskDeleteDialog.setCanceledOnTouchOutside(false);
                taskDeleteDialog.show();


            }
        });
        return view;
    }




}

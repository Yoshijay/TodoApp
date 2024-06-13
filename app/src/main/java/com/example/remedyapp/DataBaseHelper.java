package com.example.remedyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="todotasks_db";

    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 10;






    public static final String TBL_USER="tbl_user";
    public static final String COL_U_ID="id";
    public static final String COL_U_USER_NAME="user_name";
    public static final String COL_U_AGE="age";
    public static final String COL_U_GENDER="gender";
    public static final String COL_U_PHONE="phone";
    public static final String COL_U_EMAIL="email";
    public static final String COL_U_PASSWORD="password";

    public static final String TBL_TODO_TASKS="tbl_todo_tasks";
    public static final String COL_T_ID="task_id";
    public static final String COL_T_TASKS="tasks";

    public static final String COL_T_DATE="date";


    private static final String CREATE_TBL_USER = "CREATE TABLE "+ TBL_USER + "("
            + COL_U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_U_USER_NAME + " TEXT NOT NULL,"
            + COL_U_AGE + " REAL NOT NULL,"
            + COL_U_GENDER + " TEXT NOT NULL,"
            + COL_U_PHONE + " TEXT NOT NULL,"
            + COL_U_EMAIL + " TEXT NOT NULL,"
            + COL_U_PASSWORD + " TEXT NOT NULL"
            + ")";

    private static final String CREATE_TBL_TODO_TASKS = "CREATE TABLE "+ TBL_TODO_TASKS + "("
            + COL_T_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_T_TASKS + " TEXT NOT NULL,"
            + COL_T_DATE + " TEXT NOT NULL"

            + ")";

    public DataBaseHelper(@Nullable Context context) {
        //, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version
//        super(context,"todo_task.db", null, 1);
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//String createTableStatement="CREATE TABLE "+TBL_USER+ "("+COL_U_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_U_USER_NAME+" TEXT,"+COL_U_AGE+" INT,"+COL_U_GENDER+" TEXT,"+COL_U_PHONE+" INT,"+COL_U_EMAIL+" TEXT,"+COL_U_PASSWORD+" TEXT)";
//db.execSQL(createTableStatement);
        db.execSQL(CREATE_TBL_USER);
        db.execSQL(CREATE_TBL_TODO_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion>oldVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_USER);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_TODO_TASKS);

            onCreate(sqLiteDatabase);
        }
    }

    public boolean addOne(UserModel userModel){
SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_U_USER_NAME,userModel.getUser_name());
        cv.put(COL_U_AGE,userModel.getAge());
        cv.put(COL_U_GENDER,userModel.getGender());
        cv.put(COL_U_PHONE,userModel.getPhone());
        cv.put(COL_U_EMAIL,userModel.getEmail());
        cv.put(COL_U_PASSWORD,userModel.getPassword());

      long insert=db.insert(TBL_USER,null,cv);

      if(insert==-1){
          return false;
      }else {
          return true;
      }
    }

    public boolean Login(UserModel userModel){
        SQLiteDatabase db=this.getReadableDatabase();
        boolean bool=false;
        String selectQuery = "SELECT * FROM tbl_user where email='"+userModel.getEmail()+"' and password='"+userModel.getPassword()+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                bool = true;
            } else {
                bool = false;
            }
        }else{
            bool = false;
        }
            cursor.close(); // Close the cur
        db.close();
        return bool;
    }

    public boolean addTask(TaskModel taskModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_T_TASKS,taskModel.getTask());
        cv.put(COL_T_DATE,taskModel.getDate());


        long insert=db.insert(TBL_TODO_TASKS,null,cv);

        if(insert==-1){
            db.close();
            return false;
        }else {
            db.close();
            return true;
        }

    }

    public ArrayList<TaskModel> getTasks(){
        ArrayList<TaskModel> returnList=new ArrayList<>();
        String queryString="SELECT * FROM "+TBL_TODO_TASKS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{
                int taskID=cursor.getInt(0);
                String task=cursor.getString(1);
                String date=cursor.getString(2);

                TaskModel taskModel= new TaskModel(taskID,task,date);
                returnList.add(taskModel);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public void updateTask(TaskModel taskModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_T_TASKS,taskModel.getTask());


        // Updating Row
        int result = db.update(TBL_TODO_TASKS, contentValues, COL_T_ID + " = ?", new String[]{String.valueOf(taskModel.getId())});
//        return result > 0; // returns tr
        db.close();
    }

    public void deleteTask(TaskModel taskModel){
        SQLiteDatabase db = this.getWritableDatabase();

       int rowsDeleted=db.delete(TBL_TODO_TASKS,COL_T_ID + " = ?", new String[]{String.valueOf(taskModel.getId())});
        if (rowsDeleted > 0) {
            Log.d("DatabaseHelper", "Task deleted successfully, ID: " + taskModel.getId());
        } else {
            Log.d("DatabaseHelper", "Task deletion failed, ID: " + taskModel.getId());
        }
        db.close();
    }

    public UserModel getUserInfo(UserModel userModel){
        SQLiteDatabase db=this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tbl_user where email='"+userModel.getEmail()+"' and password='"+userModel.getPassword()+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        int user_id=0,age=0;
        String user_name="",gender="",phone="",email="";


        if(cursor.moveToFirst()){
            do{
                 user_id=cursor.getInt(0);
                 user_name=cursor.getString(1);
                age=cursor.getInt(2);
                gender=cursor.getString(3);
                phone=cursor.getString(4);
                email=cursor.getString(5);

            }while (cursor.moveToNext());
        }
        UserModel returnList=new UserModel(user_id,user_name,age,gender,phone,email);
        cursor.close();
        db.close();
        return returnList;
    }

    public void updateUserInfo(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_U_USER_NAME,userModel.getUser_name());
        contentValues.put(COL_U_AGE,userModel.getAge());
        contentValues.put(COL_U_PHONE,userModel.getPhone());
        contentValues.put(COL_U_EMAIL,userModel.getEmail());


        // Updating Row
        int result = db.update(TBL_USER, contentValues, COL_U_ID + " = ?", new String[]{String.valueOf(userModel.getId())});
//        return result > 0;
// returns tr
        if(result>0){

        }
        db.close();
    }
}

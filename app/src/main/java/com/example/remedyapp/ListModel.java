package com.example.remedyapp;

public class ListModel {
    private int id;
    private int user_id;
    private String task;

    private String date;

    public ListModel(int id, int user_id, String task, String date) {
        this.id = id;
        this.user_id = user_id;
        this.task = task;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String tas) {
        this.task = tas;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}

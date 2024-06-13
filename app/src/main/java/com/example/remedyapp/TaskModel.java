package com.example.remedyapp;

import java.sql.Date;

public class TaskModel {

    private int id;
    private String task;
    private String date;

    public TaskModel() {

    }
    public TaskModel(int id, String task, String date) {
        this.id = id;
        this.task = task;
        this.date = date;
    }

    public TaskModel(String task, String date) {

        this.task = task;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }








}

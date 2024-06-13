package com.example.remedyapp;

public class UserModel {
    private int id;
    private String user_name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String password;

    public UserModel(int id, String user_name, int age, String gender, String phone, String email, String password) {
        this.id = id;
        this.user_name = user_name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    public UserModel(String user_name, int age, String gender, String phone, String email, String password) {

        this.user_name = user_name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public UserModel(int id,String user_name, int age, String gender, String phone, String email) {
        this.id=id;
        this.user_name = user_name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;

    }

public UserModel(){

}
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

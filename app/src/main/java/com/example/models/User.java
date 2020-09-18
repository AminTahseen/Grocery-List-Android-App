package com.example.models;

public class User
{
   private int User_ID;
   private String User_Name;
   private String User_city;
   private String User_type;
   private String User_pass;

    public User(String user_Name, String user_city, String user_type,String user_pass) {
        User_Name = user_Name;
        User_city = user_city;
        User_type = user_type;
        User_pass = user_pass;
    }

    public User(int user_ID, String user_Name, String user_city, String user_type, String user_pass) {
        User_ID = user_ID;
        User_Name = user_Name;
        User_city = user_city;
        User_type = user_type;
        User_pass = user_pass;
    }

    public User(){}

    public String getUser_pass() {
        return User_pass;
    }

    public void setUser_pass(String user_pass) {
        User_pass = user_pass;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_city() {
        return User_city;
    }

    public void setUser_city(String user_city) {
        User_city = user_city;
    }

    public String getUser_type() {
        return User_type;
    }

    public void setUser_type(String user_type) {
        User_type = user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_ID=" + User_ID +
                "User_Name='" + User_Name + '\'' +
                "User_city='" + User_city + '\'' +
                "User_type='" + User_type + '\'' +
                "ser_pass='" + User_pass + '\'' +
                '}';
    }
}

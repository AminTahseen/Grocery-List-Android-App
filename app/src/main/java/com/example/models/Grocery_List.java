package com.example.models;

public class Grocery_List {
    private int List_ID;
    private String List_Name;
    private int List_User_ID;

    public Grocery_List(int list_ID, String list_Name, int list_User_ID) {
        List_ID = list_ID;
        List_Name = list_Name;
        List_User_ID = list_User_ID;
    }

    public Grocery_List( String list_Name, int list_User_ID) {
        List_Name = list_Name;
        List_User_ID = list_User_ID;
    }
    public Grocery_List(){}

    public int getList_ID() {
        return List_ID;
    }

    public void setList_ID(int list_ID) {
        List_ID = list_ID;
    }

    public String getList_Name() {
        return List_Name;
    }

    public void setList_Name(String list_Name) {
        List_Name = list_Name;
    }

    public int getList_User_ID() {
        return List_User_ID;
    }

    public void setList_User_ID(int list_User_ID) {
        List_User_ID = list_User_ID;
    }
}

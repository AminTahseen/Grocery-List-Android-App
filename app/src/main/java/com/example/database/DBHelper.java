package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String Database_Name = "GroceryListApp.db";
    private static final int Version = 1;


    private static final String tag = "DBHelper";

    //User Table
    public static final String TABLE_User= "TBL_User";
    public static final String COL_User_1 = "User_ID";
    public static final String COL_User_2 = "Name";
    public static final String COL_User_3 = "City";
    public static final String COL_User_4 = "User_type";
    public static final String COL_User_5 = "User_Pass";
    public static final String  Create_TBL_User = "CREATE TABLE "+TABLE_User+"("
            +COL_User_1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_User_2+ " TEXT,"
            +COL_User_3+ " TEXT,"
            +COL_User_4+ " TEXT,"
            +COL_User_5+ " TEXT"
            +");";

    //Grocery Item Table
    public static final String TABLE_Grocery_Item= "TBL_Grocery_Item";
    public static final String COL_GI_1 = "Item_ID";
    public static final String COL_GI_2 = "Item_Name";
    public static final String COL_GI_3 = "Item_Code";
    public static final String COL_GI_4 = "Item_Price";
    public static final String COL_GI_5= "Item_User_ID";
    public static final String  Create_TBL_Grocery_Item = "CREATE TABLE "+TABLE_Grocery_Item+"("
            +COL_GI_1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_GI_2+ " TEXT,"
            +COL_GI_3+ " TEXT,"
            +COL_GI_4+ " TEXT,"
            +COL_GI_5+ " INTEGER"
            +");";


    //Grocery List Table
    public static final String TABLE_Grocery_List= "TBL_Grocery_List";
    public static final String COL_GL_1 = "List_ID";
    public static final String COL_GL_2 = "List_Name";
    public static final String COL_GL_3 = "List_User_ID";
    public static final String  Create_TBL_Grocery_List = "CREATE TABLE "+TABLE_Grocery_List+"("
            +COL_GL_1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_GL_2+ " TEXT,"
            +COL_GL_3+ " INTEGER NOT NULL"
            +");";

    //Grocery List Items Table
    public static final String TABLE_Grocery_List_Item= "TBL_Grocery_List_Items";
    public static final String COL_GLI_1 = "List_Item_ID";
    public static final String COL_GLI_2 = "List_Item_Name";
    public static final String COL_GLI_3 = "List_Item_Price";
    public static final String COL_GLI_4 = "Item_Grocery_List_ID";
    public static final String  Create_TBL_Grocery_List_Items = "CREATE TABLE "+TABLE_Grocery_List_Item+"("
            +COL_GLI_1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_GLI_2+ " TEXT,"
            +COL_GLI_3+ " TEXT,"
            +COL_GLI_4+ " INTEGER"
            +");";

    public DBHelper(Context context)
    {
        super(context, Database_Name, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        DB.execSQL(Create_TBL_User);
        DB.execSQL(Create_TBL_Grocery_Item);
        DB.execSQL(Create_TBL_Grocery_List);
        DB.execSQL(Create_TBL_Grocery_List_Items);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_User);
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_Grocery_Item);
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_Grocery_List);
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_Grocery_List_Item);
        onCreate(db);
    }
}

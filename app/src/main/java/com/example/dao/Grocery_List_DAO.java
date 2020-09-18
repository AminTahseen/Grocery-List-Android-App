package com.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.DBHelper;
import com.example.models.Grocery_List;

import java.util.ArrayList;

public class Grocery_List_DAO {

    ArrayList<String> ListNames = new ArrayList<String>();

    DBHelper db;

    public Grocery_List_DAO(Context context)
    {
        ListNames.clear();
        db=new DBHelper(context);
    }
    public boolean Create_Record(Grocery_List obj)
    {
        SQLiteDatabase sqlDB = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(db.COL_GL_2,obj.getList_Name());
        contentValues.put(db.COL_GL_3,obj.getList_User_ID());
        long Result = sqlDB.insert(DBHelper.TABLE_Grocery_List, null, contentValues);
        if (Result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void Delete_Record()
    {

    }
    public void Update_Record()
    {

    }
    public ArrayList<Grocery_List> GetAllList()
    {
        return null;
    }

    public  ArrayList<String> GroceryListNames(int user_id){
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_List+" where "+DBHelper.COL_GL_3+"="+user_id+"",null);
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GL_2));
                if(ListNames.contains(name)){

                }else{
                    ListNames.add(name);
                }
                cursor.moveToNext();
            }
        }

        return ListNames;
    }

    public  ArrayList<Integer> GroceryListIDs(int user_id)
    {
        ArrayList<Integer> ListIDs = new ArrayList<>();

        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_List+" where "+DBHelper.COL_GL_3+"="+user_id+"",null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GL_1));
                if(ListIDs.contains(id)){

                }
                else {
                    ListIDs.add(id);
                }
                cursor.moveToNext();
            }
        }
        return ListIDs;
    }

    public Grocery_List Get_Grocery_List()
    {
        Grocery_List model=new Grocery_List();
        return model;
    }

}

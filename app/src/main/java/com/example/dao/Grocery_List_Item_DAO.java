package com.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.DBHelper;
import com.example.models.Grocery_List_Item;

import java.util.ArrayList;

public class Grocery_List_Item_DAO {

    DBHelper db;

    public  Grocery_List_Item_DAO(Context context)
    {
        db=new DBHelper(context);
    }
    public boolean Create_Record(Grocery_List_Item obj)
    {
        SQLiteDatabase sqlDB = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(db.COL_GLI_2,obj.getList_Item_Name());
        contentValues.put(db.COL_GLI_3,obj.getList_Item_Price());
        contentValues.put(db.COL_GLI_4,obj.getItem_Grocery_List_ID());
        long Result = sqlDB.insert(DBHelper.TABLE_Grocery_List_Item, null, contentValues);
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
    public ArrayList<Grocery_List_Item> GetAllRecords()
    {
        return null;
    }
    public ArrayList<String> GetItems_names(int list_id)
    {
        ArrayList<String> ListItems = new ArrayList<String>();
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_List_Item+" where "+DBHelper.COL_GLI_4+"="+list_id+"",null);
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GLI_2));
                if(ListItems.contains(name)){

                }else{
                    ListItems.add(name);
                }
                cursor.moveToNext();
            }
        }

        return ListItems;
    }

    public ArrayList<Integer> GetItems_IDS(int list_id)
    {
        ArrayList<Integer> ListItems = new ArrayList<Integer>();
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_List_Item+" where "+DBHelper.COL_GLI_4+"="+list_id+"",null);
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
               int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GLI_1));
                if(ListItems.contains(id)){

                }else{
                    ListItems.add(id);
                }
                cursor.moveToNext();
            }
        }

        return ListItems;
    }

    public Grocery_List_Item Get_ItemDetails(int item_id)
    {
        Grocery_List_Item model=new Grocery_List_Item();
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_List_Item+" where "+DBHelper.COL_GLI_1+"="+item_id+"",null);

        if ( cursor.moveToFirst() )
        {
            model.setList_Item_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GLI_1)));
            model.setList_Item_Name(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GLI_2)));
            model.setList_Item_Price(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GLI_3)));
            model.setItem_Grocery_List_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GLI_4)));
        } else {
            model.setList_Item_ID(0);
            model.setList_Item_Name("Demo");
            model.setList_Item_Price("Demo");
            model.setItem_Grocery_List_ID(0);
        }
        cursor.close();
        return model;
    }

    public int deleteItem(int item_id)
    {
        SQLiteDatabase sqlDB = db.getWritableDatabase();

       return sqlDB.delete(DBHelper.TABLE_Grocery_List_Item,"List_Item_ID=?",new String[]{String.valueOf(item_id)});


    }
}

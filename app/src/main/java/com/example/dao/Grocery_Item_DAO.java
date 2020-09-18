package com.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.DBHelper;
import com.example.models.Grocery_Item;

import java.util.ArrayList;

public class Grocery_Item_DAO {

    DBHelper db;

    private String[] All_Columns={db.COL_GI_1,db.COL_GI_2,db.COL_GI_3,db.COL_GI_4,db.COL_GI_5};

    public Grocery_Item_DAO(Context context)
    {
        db=new DBHelper(context);
    }

    public boolean Create_Record(Grocery_Item obj)
    {
        SQLiteDatabase sqlDB = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_GI_2,obj.getItem_Name());
        contentValues.put(DBHelper.COL_GI_3,obj.getItem_Code());
        contentValues.put(DBHelper.COL_GI_4,obj.getItem_Price());
        contentValues.put(DBHelper.COL_GI_5,obj.getItem_User_ID());
        long Result = sqlDB.insert(DBHelper.TABLE_Grocery_Item, null, contentValues);
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
    public ArrayList<String> GetAllRecords(int uid)
    {
        ArrayList<String> ListItems = new ArrayList<String>();
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_Item+" where "+DBHelper.COL_GI_5+"="+uid+"",null);
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_2));
                if(ListItems.contains(name))
                {

                }else{
                    ListItems.add(name);
                }
                cursor.moveToNext();
            }
        }

        return ListItems;
    }

    public Grocery_Item Get_Grocery_Item(String item_code)
    {
        Grocery_Item model=new Grocery_Item();

        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_Item+" where "+DBHelper.COL_GI_3+"='"+item_code+"'",null);

        if ( cursor.moveToFirst() )
        {
            model.setItem_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GI_1)));
            model.setItem_Name(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_2)));
            model.setItem_Code(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_3)));
            model.setItem_Price(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_4)));
            model.setItem_User_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GI_5)));
        } else {
            model.setItem_ID(0);
            model.setItem_Name("Demo");
            model.setItem_Code("Demo Code");
            model.setItem_Price("Demo Price");
            model.setItem_User_ID(0);
        }
        cursor.close();

        return model;
    }

    public Grocery_Item Get_Grocery_ItemByName(String item_name)
    {
        Grocery_Item model=new Grocery_Item();

        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_Grocery_Item+" where "+DBHelper.COL_GI_2+"='"+item_name+"'",null);

        if ( cursor.moveToFirst() )
        {
            model.setItem_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GI_1)));
            model.setItem_Name(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_2)));
            model.setItem_Code(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_3)));
            model.setItem_Price(cursor.getString(cursor.getColumnIndex(DBHelper.COL_GI_4)));
            model.setItem_User_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GI_5)));
        } else {
            model.setItem_ID(0);
            model.setItem_Name("Demo");
            model.setItem_Code("Demo Code");
            model.setItem_Price("Demo Price");
            model.setItem_User_ID(0);
        }
        cursor.close();

        return model;
    }

    public ArrayList<String> GetAllGroceryItemsName()
    {
        return null;
    }


}

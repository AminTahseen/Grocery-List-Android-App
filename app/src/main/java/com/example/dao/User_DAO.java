package com.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.DBHelper;
import com.example.models.User;

import java.util.ArrayList;

public class User_DAO {

    DBHelper db;

    private String[] All_Columns={db.COL_User_1,db.COL_User_2,db.COL_User_3,db.COL_User_4,db.COL_User_5};


    public User_DAO(Context context)
    {
        db=new DBHelper(context);
    }

    public Boolean Create_Record(User obj)
    {
        SQLiteDatabase sqlDB = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_User_2,obj.getUser_Name());
        contentValues.put(DBHelper.COL_User_3,obj.getUser_city());
        contentValues.put(DBHelper.COL_User_4,obj.getUser_type());
        contentValues.put(DBHelper.COL_User_5,obj.getUser_pass());

        long Result = sqlDB.insert(DBHelper.TABLE_User, null, contentValues);
        if (Result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void Delete_Record(User obj)
    {

    }
    public void Update_Record(User obj)
    {

    }
    public ArrayList<User> GetAllRecords()
    {
        return null;
    }
    public ArrayList<String> GetAllSellers()
    {
        ArrayList<String> Sellers = new ArrayList<>();

        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor  cursor = sqlDB.rawQuery("select * from "+DBHelper.TABLE_User+" where "+DBHelper.COL_User_4+"= 'Seller'",null);
        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast())
            {
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_User_2));
                Sellers.add(name);
                cursor.moveToNext();
            }
        }

        return Sellers;
    }

    public User Get_user(int User_id)
    {
        User model=new User();
        return model;
    }

    public User verifyUser(String Uname,String Upass)
    {
        User model=new User();
        SQLiteDatabase sqlDB = db.getReadableDatabase();
        Cursor cursor=sqlDB.query(DBHelper.TABLE_User,All_Columns,DBHelper.COL_User_2+"=? AND "+DBHelper.COL_User_5+"=? ",new String[]{Uname,Upass},null, null, null, null);

        if ( cursor.moveToFirst() )
        {
            model.setUser_ID(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_User_1)));
            model.setUser_Name(cursor.getString(cursor.getColumnIndex(DBHelper.COL_User_2)));
            model.setUser_city(cursor.getString(cursor.getColumnIndex(DBHelper.COL_User_3)));
            model.setUser_type(cursor.getString(cursor.getColumnIndex(DBHelper.COL_User_4)));
            model.setUser_pass(cursor.getString(cursor.getColumnIndex(DBHelper.COL_User_5)));

        } else {
            model.setUser_ID(0);
            model.setUser_Name("Demo");
            model.setUser_city("Demo_City");
            model.setUser_type("Demo_Type");
            model.setUser_pass("DemoPass");
        }
        cursor.close();
        return model;
    }


}

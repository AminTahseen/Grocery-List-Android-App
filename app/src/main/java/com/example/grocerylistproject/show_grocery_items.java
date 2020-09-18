package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_Item_DAO;

import java.util.ArrayList;

public class show_grocery_items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grocery_items);

        Intent intent_for_list_id=getIntent();
        String u_id=intent_for_list_id.getStringExtra("user_ID");
        int user_id=Integer.parseInt(u_id);

        Grocery_Item_DAO dao=new Grocery_Item_DAO(this);

        ListView mylist=(ListView)findViewById(R.id.items_list);

        final ArrayList<String> items = dao.GetAllRecords(user_id);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);

        mylist.setAdapter(adapter);
    }
}

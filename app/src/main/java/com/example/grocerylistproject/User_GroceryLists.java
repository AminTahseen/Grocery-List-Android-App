package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_List_DAO;

import java.util.ArrayList;

public class User_GroceryLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__grocery_lists);
        final ListView groceryListNames=(ListView)findViewById(R.id.Grocery_lists);
        Grocery_List_DAO dao=new Grocery_List_DAO(this);


        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");

        int user_id=Integer.parseInt(uid);
        final ArrayList<String> List_Name = dao.GroceryListNames(user_id);
        final ArrayList<Integer> List_ids=dao.GroceryListIDs(user_id);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,List_Name);
        groceryListNames.setAdapter(adapter);

        groceryListNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int index_of_LIST_NAME = List_Name.indexOf(List_Name.get(position));
                int id_of_LIST_NAME=List_ids.get(index_of_LIST_NAME);
                String lid=Integer.toString(id_of_LIST_NAME);
                Intent Show_Grocery_List_items =new Intent(getApplicationContext(),Grocery_list_items_list.class);
                Show_Grocery_List_items.putExtra("list_id",lid);
                startActivity(Show_Grocery_List_items);
            }
        });
    }
}

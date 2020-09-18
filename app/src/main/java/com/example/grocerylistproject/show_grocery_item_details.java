package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_List_Item_DAO;
import com.example.models.Grocery_List_Item;

public class show_grocery_item_details extends AppCompatActivity {
    int Item_id;
    Grocery_List_Item_DAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grocery_item_details);
        TextView item_detail=(TextView)findViewById(R.id.item_detail);

        Intent intent_for_item_id=getIntent();
        String i_id=intent_for_item_id.getStringExtra("item_id");

        Item_id=Integer.parseInt(i_id);

        dao = new Grocery_List_Item_DAO(this);

        Grocery_List_Item item=dao.Get_ItemDetails(Item_id);

        item_detail.setText(item.toString());

    }

}

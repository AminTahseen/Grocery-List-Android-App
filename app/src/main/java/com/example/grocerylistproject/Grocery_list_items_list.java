package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_List_Item_DAO;

import java.util.ArrayList;

public class Grocery_list_items_list extends AppCompatActivity {
    Grocery_List_Item_DAO dao;
    ListView item_lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list_items_list);

        item_lists=(ListView)findViewById(R.id.items_from_grocery_list);

        dao = new Grocery_List_Item_DAO(this);

        Intent intent_for_list_id=getIntent();
        String L_id=intent_for_list_id.getStringExtra("list_id");
        int List_id=Integer.parseInt(L_id);

        final ArrayList<String> Items =dao.GetItems_names(List_id);
        final ArrayList<Integer> Items_ids=dao.GetItems_IDS(List_id);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Items);


        item_lists.setAdapter(adapter);

        item_lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l)
            {
                int index_of_Item_NAME = Items.indexOf(Items.get(pos));
                int id_of_Item_NAME=Items_ids.get(index_of_Item_NAME);
                String i_id=Integer.toString(id_of_Item_NAME);

                Intent Item_detail=new Intent(getApplicationContext(),show_grocery_item_details.class);
                Item_detail.putExtra("item_id",i_id);
                startActivity(Item_detail);

            }
        });

        item_lists.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                int index_of_Item_NAME = Items.indexOf(Items.get(pos));
                int id=Items_ids.get(index_of_Item_NAME);
                int res=dao.deleteItem(id);
                if(res >0)
                {
                    Show_ToastMessage("Item Deleted From Grocery List !");
                }else{
                    Show_ToastMessage("Something Went Wrong...");
                }

                return true;
            }
        });

    }
    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GroceryListOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list_options);
    }

    public void CreateList(View view)
    {
        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        Intent createList=new Intent(getApplicationContext(),create_grocery_list.class);
        createList.putExtra("User_id",uid);
        startActivity(createList);
    }
    public void ViewUserLists(View view)
    {
        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        Intent viewList=new Intent(getApplicationContext(),User_GroceryLists.class);
        viewList.putExtra("User_id",uid);
        startActivity(viewList);
    }
}

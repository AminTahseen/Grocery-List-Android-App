package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.User_DAO;

import java.util.ArrayList;

public class Show_Available_Sellers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__available__sellers);
        User_DAO dao=new User_DAO(this);

        ListView sellerList=(ListView)findViewById(R.id.sellers_list);


        final ArrayList<String> Sellers = dao.GetAllSellers();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Sellers);

        sellerList.setAdapter(adapter);

        sellerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("User clicked ", Sellers.get(position));
                Intent intent=getIntent();
                String type=intent.getStringExtra("User_Type");
                String uid=intent.getStringExtra("User_id");

                Intent New_Product=new Intent(getApplicationContext(),New_Product.class);
                New_Product.putExtra("User_Type",type);
                New_Product.putExtra("user_ID",uid);
                startActivity(New_Product);
            }
        });


    }
}

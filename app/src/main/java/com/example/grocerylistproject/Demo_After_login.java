package com.example.grocerylistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Demo_After_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__after_login);
    }

    public void Login_Seller(View view) {
        Intent Seller_Dashboard=new Intent(getApplicationContext(), Seller_Grid_Dashboard.class);
        startActivity(Seller_Dashboard);
    }

    public void Login_Buyer(View view) {
        Intent Buyer_Dashboard=new Intent(getApplicationContext(),Buyer_Grid_Dashboard.class);
        startActivity(Buyer_Dashboard);
    }
}

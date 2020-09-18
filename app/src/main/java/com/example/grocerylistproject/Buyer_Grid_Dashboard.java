package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Buyer_Grid_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer__grid__dashboard);

    }

    public void NewProduct(View view) {
        Intent intent=getIntent();
        String type=intent.getStringExtra("User_Type");
        String uid=intent.getStringExtra("User_id");

        Intent Available_Sellers=new Intent(getApplicationContext(),Show_Available_Sellers.class);
        Available_Sellers.putExtra("User_id",uid);
        Available_Sellers.putExtra("User_Type",type);
        startActivity(Available_Sellers);
    }

    public void AccountDetails(View view) {
        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        String uname=intent.getStringExtra("User_Name");
        String upass=intent.getStringExtra("User_Pass");
        String ucity=intent.getStringExtra("User_City");

        Intent AccountDetails=new Intent(getApplicationContext(),User_Profile.class);

        AccountDetails.putExtra("User_Name",uname);
        AccountDetails.putExtra("User_Pass",upass);
        AccountDetails.putExtra("User_City",ucity);

        startActivity(AccountDetails);
    }

    public void listOptions(View view) {

        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        String uname=intent.getStringExtra("User_Name");
        String upass=intent.getStringExtra("User_Pass");
        String ucity=intent.getStringExtra("User_City");

        Intent ListOptions=new Intent(getApplicationContext(),GroceryListOptions.class);
        ListOptions.putExtra("User_id",uid);
        startActivity(ListOptions);
    }
}

package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Seller_Grid_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_grid);
    }

    public void NewProduct(View view) {
        Intent NewProduct=new Intent(getApplicationContext(),New_Product.class);
        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        NewProduct.putExtra("user_ID",uid);

        Intent intent2=getIntent();
        String type=intent2.getStringExtra("User_Type");
        NewProduct.putExtra("User_Type",type);

        startActivity(NewProduct);
    }
    public void AccountDetails(View view) {
        Intent intent=getIntent();
        String uname=intent.getStringExtra("User_Name");
        String upass=intent.getStringExtra("User_Pass");
        String ucity=intent.getStringExtra("User_City");

        Intent AccountDetails=new Intent(getApplicationContext(),User_Profile.class);

        AccountDetails.putExtra("User_Name",uname);
        AccountDetails.putExtra("User_Pass",upass);
        AccountDetails.putExtra("User_City",ucity);

        startActivity(AccountDetails);
    }

    public void Allproducts(View view)
    {
        Intent AllProduct=new Intent(getApplicationContext(),show_grocery_items.class);
        Intent intent=getIntent();
        String uid=intent.getStringExtra("User_id");
        AllProduct.putExtra("user_ID",uid);

        startActivity(AllProduct);
    }


}

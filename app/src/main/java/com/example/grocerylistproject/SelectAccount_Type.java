package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectAccount_Type extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account__type);
    }

    public void CreateAccountBuyer(View view) {
        Intent CreateAccount=new Intent(getApplicationContext(),CreateAccount.class);
        CreateAccount.putExtra("User_Type","Buyer");
        startActivity(CreateAccount);
    }

    public void CreateAccountSeller(View view) {
        Intent CreateAccount=new Intent(getApplicationContext(),CreateAccount.class);
        CreateAccount.putExtra("User_Type","Seller");
        startActivity(CreateAccount);
    }
}

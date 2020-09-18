package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class New_Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__product);
    }

    public void AddProductByCode(View view) {
        Intent intent_for_type = getIntent();
        String type = intent_for_type.getStringExtra("User_Type");
        String uid = intent_for_type.getStringExtra("user_ID");

        if (type.equals("Buyer"))
        {
            Intent AddProductByCode = new Intent(getApplicationContext(), Barcode_Scan_For_Buyer.class);
            AddProductByCode.putExtra("user_ID", uid);
            startActivity(AddProductByCode);
        }
        else if (type.equals("Seller"))
        {
            Intent AddProductByCode = new Intent(getApplicationContext(), Barcode_Scan_For_Seller.class);
            Intent intent = getIntent();
            String usid = intent.getStringExtra("user_ID");
            AddProductByCode.putExtra("user_ID", usid);

            startActivity(AddProductByCode);
        }

    }

    public void AddProductByManually(View view)
    {
        Intent intent_for_type = getIntent();
        String type = intent_for_type.getStringExtra("User_Type");
        String uid = intent_for_type.getStringExtra("user_ID");

        if (type.equals("Buyer"))
        {
            Intent findProductByText = new Intent(getApplicationContext(),add_item_bytext.class);
            findProductByText.putExtra("user_id",uid);
            startActivity(findProductByText);

        } else if (type.equals("Seller"))
        {
            Intent AddProductByText = new Intent(getApplicationContext(), Scanned_Product.class);
            Intent intent = getIntent();
            String usid = intent.getStringExtra("user_ID");
            AddProductByText.putExtra("user_ID", usid);
            startActivity(AddProductByText);


        }
    }
}

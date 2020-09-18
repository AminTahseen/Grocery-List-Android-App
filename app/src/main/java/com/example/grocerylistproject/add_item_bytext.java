package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class add_item_bytext extends AppCompatActivity {

    EditText item_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_bytext);
        item_name=(EditText)findViewById(R.id.item_name);
    }

    public void gotoScanned(View view) {
        Intent intent_for_type = getIntent();
        String uid = intent_for_type.getStringExtra("user_id");
        String i_name=item_name.getText().toString();

        Intent scannedProductForBuyer=new Intent(getApplicationContext(),Scanned_Product_For_Buyer.class);
        scannedProductForBuyer.putExtra("user_ID", uid);
        scannedProductForBuyer.putExtra("item_name", i_name);

        startActivity(scannedProductForBuyer);

    }
}

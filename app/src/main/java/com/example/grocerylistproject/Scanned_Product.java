package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_Item_DAO;
import com.example.models.Grocery_Item;

public class Scanned_Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned__product);

        final EditText Prod_code=(EditText) findViewById(R.id.prod_code);
        final EditText Prod_name=(EditText) findViewById(R.id.prod_name);
        final EditText Prod_price=(EditText) findViewById(R.id.prod_price);
        Button btn_create=(Button) findViewById(R.id.createProduct);


        final Intent intent=getIntent();
        String code=intent.getStringExtra("Code");
        if(code!=null)
        {
            Prod_code.setText(code);
        }else{
            Prod_code.setText("none");
        }


        final Grocery_Item_DAO dao=new Grocery_Item_DAO(this);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String item_Name=Prod_name.getText().toString();
                String item_Code=Prod_code.getText().toString();
                String item_Price=Prod_price.getText().toString();
                String uid=intent.getStringExtra("user_ID");
                int item_User_ID=Integer.parseInt(uid);
                try {
                    Grocery_Item model=new Grocery_Item(item_Name,item_Code,item_Price,item_User_ID);
                    Boolean result = dao.Create_Record(model);
                    if(result)
                    {
                        Show_ToastMessage("Product Successfully Added !");
                    }else
                    {
                        Show_ToastMessage("Failed To Add A Product ");
                    }
                }
                catch (Exception er)
                {
                    Log.e("ScannedProduct ",er.getMessage());
                  //  Log.e("CreateAccount","User OBJ - "+model.getUser_Name());
                }

            }
        });

    }
    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_List_DAO;
import com.example.database.DBHelper;
import com.example.models.Grocery_List;

public class create_grocery_list extends AppCompatActivity {
DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_grocery_list);
        Button createList=(Button)findViewById(R.id.btnCreateList);
        final EditText listName=(EditText)findViewById(R.id.ListName);
        final Grocery_List_DAO dao=new Grocery_List_DAO(this);

        Intent intent=getIntent();
        final String uid=intent.getStringExtra("User_id");

        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Lname=listName.getText().toString();

                int user_id=Integer.parseInt(uid);

                try {
                    Grocery_List obj =new Grocery_List(Lname,user_id);
                    Boolean result = dao.Create_Record(obj);
                    if(result)
                    {
                        Show_ToastMessage(" Grocery List Created !");
                    }else
                    {
                        Show_ToastMessage("Failed To Create a Grocery List");
                    }
                }
                catch (Exception er)
                {
                    Log.e("create_grocery_list : ",er.getMessage());
                }
            }
        });
    }
    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.User_DAO;
import com.example.database.DBHelper;
import com.example.models.User;

public class CreateAccount extends AppCompatActivity {
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        final EditText user_name=(EditText)findViewById(R.id.username);
        final EditText user_pass=(EditText)findViewById(R.id.userpass);
        final EditText user_city=(EditText)findViewById(R.id.user_city);
        Button create=(Button)findViewById(R.id.CreateAccount);
        final User_DAO dao=new User_DAO(this);

        Intent intent=getIntent();
        final String user_type=intent.getStringExtra("User_Type");


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName=user_name.getText().toString();
                String userPass=user_pass.getText().toString();
                String userCity=user_city.getText().toString();
                String userType=user_type;
                try {
                    User model=new User(userName,userCity,userType,userPass);
                    Boolean result = dao.Create_Record(model);
                    if(result)
                    {
                        Show_ToastMessage(userType+" Account Successfully Created !");
                    }else
                        {
                            Show_ToastMessage("Failed To Create An Account ");
                        }
                }
                catch (Exception er)
                {
                    User model=new User(userName,userCity,userType,userPass);
                    Log.e("CreateAccount",er.getMessage());
                    Log.e("CreateAccount","User OBJ - "+model.getUser_Name());
                }
            }
        });


    }
    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

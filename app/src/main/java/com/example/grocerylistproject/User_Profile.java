package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class User_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);

        EditText name=(EditText)findViewById(R.id.username);
        EditText pass=(EditText)findViewById(R.id.userpass);
        EditText city=(EditText)findViewById(R.id.usercity);
        Button btnLogout=(Button)findViewById(R.id.logout);


        Intent intent=getIntent();
        String uname=intent.getStringExtra("User_Name");
        String upass=intent.getStringExtra("User_Pass");
        String ucity=intent.getStringExtra("User_City");


        name.setText(uname);
        pass.setText(upass);
        city.setText(ucity);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Logout=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Logout);
                finish();
            }
        });

    }

}

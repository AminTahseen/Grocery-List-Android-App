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

public class MainActivity extends AppCompatActivity {
DBHelper DB;

Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.btnlogin);

        final EditText userName=(EditText)findViewById(R.id.username);
        final EditText userPass=(EditText)findViewById(R.id.userpass);


        DB=new DBHelper(this);
        final User_DAO dao=new User_DAO(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u_name=userName.getText().toString();
                String u_pass=userPass.getText().toString();

                User user_found=dao.verifyUser(u_name,u_pass);

                Log.e("User Name is   ",user_found.getUser_Name());
                String id= Integer.toString(user_found.getUser_ID());
                Log.e("User ID is   ",id);

                if(user_found.getUser_ID() > 0)
                {
                    Log.e("User Type is   ",user_found.getUser_type());
                    if(user_found.getUser_type().equals("Buyer"))
                    {
                        Intent Buyer_Dashboard=new Intent(getApplicationContext(),Buyer_Grid_Dashboard.class);
                        String uid=Integer.toString(user_found.getUser_ID());
                        Buyer_Dashboard.putExtra("User_id",uid);
                        Buyer_Dashboard.putExtra("User_Name",user_found.getUser_Name());
                        Buyer_Dashboard.putExtra("User_Pass",user_found.getUser_pass());
                        Buyer_Dashboard.putExtra("User_City",user_found.getUser_city());
                        Buyer_Dashboard.putExtra("User_Type",user_found.getUser_type());

                        startActivity(Buyer_Dashboard);
                        finish();
                    }
                    else if(user_found.getUser_type().equals("Seller"))
                        {
                            Intent Seller_Dashboard=new Intent(getApplicationContext(),Seller_Grid_Dashboard.class);
                            String uid=Integer.toString(user_found.getUser_ID());
                            Seller_Dashboard.putExtra("User_id",uid);
                            Seller_Dashboard.putExtra("User_Name",user_found.getUser_Name());
                            Seller_Dashboard.putExtra("User_Pass",user_found.getUser_pass());
                            Seller_Dashboard.putExtra("User_City",user_found.getUser_city());
                            Seller_Dashboard.putExtra("User_Type",user_found.getUser_type());

                            startActivity(Seller_Dashboard);
                            finish();
                        }
                }else if(user_found.getUser_ID() == 0 )
                    {
                        Show_ToastMessage("Invalid Login Credential !");
                    }
            }
        });
    }

    public void GotoAccountType(View view) {
        Intent AccountType=new Intent(getApplicationContext(),SelectAccount_Type.class);
        startActivity(AccountType);
    }

    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

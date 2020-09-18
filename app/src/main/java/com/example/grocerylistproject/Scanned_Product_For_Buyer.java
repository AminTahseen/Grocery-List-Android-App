package com.example.grocerylistproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.Grocery_Item_DAO;
import com.example.dao.Grocery_List_DAO;
import com.example.dao.Grocery_List_Item_DAO;
import com.example.models.Grocery_Item;
import com.example.models.Grocery_List_Item;

import java.util.ArrayList;

public class Scanned_Product_For_Buyer extends AppCompatActivity {
    Grocery_Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned__product__for__buyer);
        TextView scanned_item=(TextView) findViewById(R.id.scanned_item);
        final Spinner sp=(Spinner)findViewById(R.id.UserLists);
        Button btnInsertInGroceryList=(Button)findViewById(R.id.btnInsertGL);


        Grocery_List_DAO listDAO=new Grocery_List_DAO(this);

       final Grocery_List_Item_DAO GLIST_ITEM_DAO=new Grocery_List_Item_DAO(this);

        final Intent intent=getIntent();
        String code=intent.getStringExtra("Code");
        String uid=intent.getStringExtra("user_ID");
        String iname=intent.getStringExtra("item_name");


        int user_id=Integer.parseInt(uid);

       final ArrayList<String> ListNames=new ArrayList<String>();
        ArrayList<String> tempListNames=listDAO.GroceryListNames(user_id);

        for(String names : tempListNames)
        {
           ListNames.add(names);
        }


       final ArrayList<Integer> tempListIDS=listDAO.GroceryListIDs(user_id);
        final ArrayList<Integer>ListIDS=new ArrayList<>();

        for(Integer ids : tempListIDS)
        {
            ListIDS.add(ids);
        }


        Grocery_Item_DAO dao=new Grocery_Item_DAO(this);
      if(code!=null && iname==null) //code = barcode & item_name =iname
      {
          item=dao.Get_Grocery_Item(code);
          scanned_item.setText(item.toString());
      }else if(code==null && iname!=null)
      {
          item=dao.Get_Grocery_ItemByName(iname);
          scanned_item.setText(item.toString());
      }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,ListNames);

        sp.setAdapter(adapter);

        btnInsertInGroceryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index_of_LIST_NAME = ListNames.indexOf(sp.getSelectedItem().toString());
                int id_of_LIST_NAME=ListIDS.get(index_of_LIST_NAME);

                String item_name=item.getItem_Name();
                String item_price=item.getItem_Price();

                try {
                    Grocery_List_Item model=new Grocery_List_Item(item_name,item_price,id_of_LIST_NAME);
                    Boolean result = GLIST_ITEM_DAO.Create_Record(model);
                    if(result)
                    {
                        Show_ToastMessage(" Item Added In "+ListNames.get(index_of_LIST_NAME)+" !");
                    }else
                    {
                            Show_ToastMessage("Failed To Add An Item.");
                    }
                }
                catch (Exception er)
                {
                    Log.e("CreateAccount",er.getMessage());
                }
            }
        });
    }
    public void Show_ToastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

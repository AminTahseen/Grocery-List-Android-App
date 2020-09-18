package com.example.models;

public class Grocery_Item {
    private int Item_ID;
    private String Item_Name;
    private String Item_Code;
    private String Item_Price;
    private int Item_User_ID;

    public Grocery_Item(int item_ID, String item_Name, String item_Code, String item_Price, int item_User_ID) {
        Item_ID = item_ID;
        Item_Name = item_Name;
        Item_Code = item_Code;
        Item_Price = item_Price;
        Item_User_ID = item_User_ID;
    }
    public Grocery_Item(String item_Name, String item_Code, String item_Price, int item_User_ID) {
        Item_Name = item_Name;
        Item_Code = item_Code;
        Item_Price = item_Price;
        Item_User_ID = item_User_ID;
    }
    public Grocery_Item(){}

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int item_ID) {
        Item_ID = item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getItem_Code() {
        return Item_Code;
    }

    public void setItem_Code(String item_Code) {
        Item_Code = item_Code;
    }

    public String getItem_Price() {
        return Item_Price;
    }

    public void setItem_Price(String item_Price) {
        Item_Price = item_Price;
    }

    public int getItem_User_ID() {
        return Item_User_ID;
    }

    public void setItem_User_ID(int item_User_ID) {
        Item_User_ID = item_User_ID;
    }

    @Override
    public String toString() {
        return "" +
                "ID=" + Item_ID + '\n' +
                "Name=" + Item_Name + '\n' +
                "Code=" + Item_Code + '\n' +
                "Price= Rs. " + Item_Price + '\n'
                ;
    }
}

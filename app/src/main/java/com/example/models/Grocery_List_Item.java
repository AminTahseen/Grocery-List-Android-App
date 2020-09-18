package com.example.models;

public class Grocery_List_Item {
    private int List_Item_ID;
    private String List_Item_Name;
    private String List_Item_Price;
    private int Item_Grocery_List_ID;

    public Grocery_List_Item(int list_Item_ID, String list_Item_Name, String list_Item_Price, int item_Grocery_List_ID) {
        List_Item_ID = list_Item_ID;
        List_Item_Name = list_Item_Name;
        List_Item_Price = list_Item_Price;
        Item_Grocery_List_ID = item_Grocery_List_ID;
    }
    public Grocery_List_Item(String list_Item_Name, String list_Item_Price, int item_Grocery_List_ID) {
        List_Item_Name = list_Item_Name;
        List_Item_Price = list_Item_Price;
        Item_Grocery_List_ID = item_Grocery_List_ID;
    }

    public Grocery_List_Item() {}

    public int getList_Item_ID() {
        return List_Item_ID;
    }

    public void setList_Item_ID(int list_Item_ID) {
        List_Item_ID = list_Item_ID;
    }

    public String getList_Item_Name() {
        return List_Item_Name;
    }

    public void setList_Item_Name(String list_Item_Name) {
        List_Item_Name = list_Item_Name;
    }

    public String getList_Item_Price() {
        return List_Item_Price;
    }

    public void setList_Item_Price(String list_Item_Price) {
        List_Item_Price = list_Item_Price;
    }

    public int getItem_Grocery_List_ID() {
        return Item_Grocery_List_ID;
    }

    public void setItem_Grocery_List_ID(int item_Grocery_List_ID) {
        Item_Grocery_List_ID = item_Grocery_List_ID;
    }

    @Override
    public String toString() {
        return "" +
                "  List Item ID=" + List_Item_ID +
                ", List Item Name='" + List_Item_Name + '\'' +
                ", List Item Price='" + List_Item_Price + '\'';
    }
}

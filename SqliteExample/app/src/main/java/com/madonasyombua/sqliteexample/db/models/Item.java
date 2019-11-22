package com.madonasyombua.sqliteexample.db.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author madona
 *
 * Model class to hold items
 */

public class Item  {


    private String itemOne;

    private String itemTwo;

    private String itemThree;


    public Item( String itemOne, String itemTwo, String itemThree) {

        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.itemThree = itemThree;
    }

    protected Item(Parcel in) {

        itemOne = in.readString();
        itemTwo = in.readString();
        itemThree = in.readString();
    }





    public String getItemOne() {
        return itemOne;
    }

    public void setItemOne(String itemOne) {
        this.itemOne = itemOne;
    }

    public String getItemTwo() {
        return itemTwo;
    }

    public void setItemTwo(String itemTwo) {
        this.itemTwo = itemTwo;
    }

    public String getItemThree() {
        return itemThree;
    }

    public void setItemThree(String itemThree) {
        this.itemThree = itemThree;
    }


}

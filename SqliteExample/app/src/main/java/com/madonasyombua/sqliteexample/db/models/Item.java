package com.madonasyombua.sqliteexample.db.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author madona
 *
 * Model class to hold items
 */

public class Item implements Parcelable {



    private int id;

    private String itemOne;

    private String itemTwo;

    private String itemThree;


    public Item(int id, String itemOne, String itemTwo, String itemThree) {
        this.id = id;
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.itemThree = itemThree;
    }

    protected Item(Parcel in) {
        id = in.readInt();
        itemOne = in.readString();
        itemTwo = in.readString();
        itemThree = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(itemOne);
        parcel.writeString(itemTwo);
        parcel.writeString(itemThree);
    }
}

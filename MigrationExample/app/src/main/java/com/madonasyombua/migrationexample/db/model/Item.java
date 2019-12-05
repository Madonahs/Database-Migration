package com.madonasyombua.migrationexample.db.model;


/**
 * @author madona
 */

public class Item {

    private int  item;
    private String item_one;
    private String item_two;

    // empty constructor
    public  Item(){

    }

    public Item(int item, String item_one, String item_two) {
        this.item = item;
        this.item_one = item_one;
        this.item_two = item_two;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getItem_one() {
        return item_one;
    }

    public void setItem_one(String item_one) {
        this.item_one = item_one;
    }

    public String getItem_two() {
        return item_two;
    }

    public void setItem_two(String item_two) {
        this.item_two = item_two;
    }
}

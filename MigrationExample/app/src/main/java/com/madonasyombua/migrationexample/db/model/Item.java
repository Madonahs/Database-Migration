package com.madonasyombua.migrationexample.db.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author madona syombua
 *
 * A basic class representing an entity that is a row in a one-column database table it also
 *   holds the accessor and mutotor methods
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 */
@Entity
public class Item {

    @PrimaryKey
    private int  item;
    private String item_one;
    private String item_two;

    // empty constructor
    public  Item(){

    }

    @Ignore
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

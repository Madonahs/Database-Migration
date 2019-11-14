package com.madonasyombua.roomexample.room.entity;



import androidx.room.ColumnInfo;
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


@Entity(tableName = "items")
public class Item {


    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "itemOme")
    private String item_one;
    private String item_two;
    private String item_three;


    /**
     * first constructor
     * @param item_one item one
     * @param item_two item two
     * @param item_three item three
     *
     */
    @Ignore
    public Item(String item_one, String item_two, String item_three) {
        this.item_one = item_one;
        this.item_two = item_two;
        this.item_three = item_three;
    }

    /**
     * second constructor with an id
     * @param id int id
     * @param item_one string item one
     * @param item_two string item two
     * @param item_three string item three
     */

    public Item(int id, String item_one, String item_two, String item_three) {
        this.id = id;
        this.item_one = item_one;
        this.item_two = item_two;
        this.item_three = item_three;
    }


    /**
     * get item one
     * @return item one
     */
    public String getItem_one() {
        return item_one;
    }

    /**
     * get item set item one
     * @param item_one item two
     */
    public void setItem_one(String item_one) {
        this.item_one = item_one;
    }

    /**
     * get item two
     * @return item two
     */

    public String getItem_two() {
        return item_two;
    }

    /**
     * set item two
     * @param item_two item two
     */
    public void setItem_two(String item_two) {
        this.item_two = item_two;
    }

    /**
     * get item three
     * @return item three
     */

    public String getItem_three() {
        return item_three;
    }

    /**
     * set item three
     * @param item_three item three
     */

    public void setItem_three(String item_three) {
        this.item_three = item_three;
    }


    /**
     * get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }





}

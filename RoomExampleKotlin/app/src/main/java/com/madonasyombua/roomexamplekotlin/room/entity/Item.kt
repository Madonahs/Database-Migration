package com.madonasyombua.roomexamplekotlin.room.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * @author madona syombua
 *
 * A basic class representing an entity that is a row in a one-column database table it also
 * holds the accessor and mutotor methods
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 */


@Entity(tableName = "items")
class Item {


    /**
     * get id
     * @return id
     */
    /**
     * set id
     * @param id id
     */
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    /**
     * get item one
     * @return item one
     */
    /**
     * get item set item one
     * @param item_one item two
     */
    @ColumnInfo(name = "itemOme")
    var item_one: String? = null
    /**
     * get item two
     * @return item two
     */

    /**
     * set item two
     * @param item_two item two
     */
    var item_two: String? = null
    /**
     * get item three
     * @return item three
     */

    /**
     * set item three
     * @param item_three item three
     */

    var item_three: String? = null


    /**
     * first constructor
     * @param item_one item one
     * @param item_two item two
     * @param item_three item three
     */
    @Ignore
    constructor(item_one: String, item_two: String, item_three: String) {
        this.item_one = item_one
        this.item_two = item_two
        this.item_three = item_three
    }

    /**
     * second constructor with an id
     * @param id int id
     * @param item_one string item one
     * @param item_two string item two
     * @param item_three string item three
     */

    constructor(id: Int, item_one: String, item_two: String, item_three: String) {
        this.id = id
        this.item_one = item_one
        this.item_two = item_two
        this.item_three = item_three
    }


}

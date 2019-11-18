package com.madonasyombua.roomexamplekotlin.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.madonasyombua.roomexamplekotlin.room.entity.Item

/**
 * @author madona syombua
 *
 * Dao , database accessible object for the item
 * Query - from the db
 * Insert - to the db
 * Delete - from the db
 * Update - the db
 */


@Dao
interface ItemDao {


    @get:Query("SELECT * FROM items ORDER BY id")
    val allItems: LiveData<List<Item>>

    @Insert
    fun insertItem(item: Item)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateItems(item: Item)

    @Delete
    fun deleteItem(item: Item)


}

package com.madonasyombua.roomexample.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.madonasyombua.roomexample.room.entity.Item;

import java.util.List;

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
public interface ItemDao {


    @Query("SELECT * FROM items ORDER BY id")
    LiveData<List<Item>> getAllItems();

    @Insert
    void insertItem(Item item);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateItems(Item item);

    @Delete
    void deleteItem(Item item);


}

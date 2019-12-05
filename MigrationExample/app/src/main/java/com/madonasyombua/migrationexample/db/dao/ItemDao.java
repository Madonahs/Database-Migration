package com.madonasyombua.migrationexample.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.madonasyombua.migrationexample.db.model.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM item")
    List<Item> getAllItems();

    @Insert
    void insertItem(Item item);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateItems(Item item);

    @Delete
    void deleteItem(Item item);
}

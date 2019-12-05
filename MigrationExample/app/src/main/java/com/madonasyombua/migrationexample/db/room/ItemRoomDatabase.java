package com.madonasyombua.migrationexample.db.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.madonasyombua.migrationexample.db.dao.ItemDao;
import com.madonasyombua.migrationexample.db.model.Item;

/**
 * @author madona
 * Database class Item Database which extends Room Database
 * include version number = 1
 * set export schema to false
 *
 */

@Database(entities = Item.class, version = 2, exportSchema = false)
public abstract class ItemRoomDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();

    private static final String LOG_TAG = ItemRoomDatabase.class.getSimpleName();

    private static final String DATABASE_NAME = "item_table";

    private static ItemRoomDatabase itemDataBaseInstance;


    // The migration instance
    private static  final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };

    public static ItemRoomDatabase getDatabase(final Context context){

        if(itemDataBaseInstance == null){
            Log.d(LOG_TAG,"Creating Database");
            itemDataBaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    ItemRoomDatabase.class,ItemRoomDatabase.DATABASE_NAME)

                    .addMigrations(MIGRATION_1_2)
                    .build();
        }


        return  itemDataBaseInstance;



    }



}

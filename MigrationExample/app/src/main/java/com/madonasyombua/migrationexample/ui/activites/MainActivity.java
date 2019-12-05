package com.madonasyombua.migrationexample.ui.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.util.Log;

import com.madonasyombua.migrationexample.R;
import com.madonasyombua.migrationexample.db.ItemDbSqlite;
import com.madonasyombua.migrationexample.db.model.Item;
import com.madonasyombua.migrationexample.db.room.ItemRoomDatabase;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {



    public static final String LOG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //add entry to db created by sqlite helper
        ItemDbSqlite itemDbSqlite = new ItemDbSqlite(this);
        itemDbSqlite.addItems(new Item(1,"Hello","Database Migration"));
        itemDbSqlite.addItems(new Item(2,"Happy Lunch","Database Migration"));
        itemDbSqlite.addItems(new Item(3,"Happy Saturday","Database Migration"));

        Log.v(LOG,"DB Created using SQLiteOpenHelper and 3 Items  added");

        Item extractedItem = itemDbSqlite.getItems(1);
        Log.v(LOG,extractedItem.getItem_one() + " : " + extractedItem.getItem_two());






    }
}

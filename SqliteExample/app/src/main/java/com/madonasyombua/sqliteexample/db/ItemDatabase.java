package com.madonasyombua.sqliteexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.madonasyombua.sqliteexample.db.contracts.ItemContract;
import com.madonasyombua.sqliteexample.db.models.Item;

public class ItemDatabase extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "item_db"; // database name

    private static final int DATABASE_VERSION = 1; // database version

    // constructor item database
    public ItemDatabase(Context context){

        super(context,DATABASE_NAME, null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        // Create a table to hold item data

        final String SQLITE_DATABASE_ITEM_TABLE = "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + "( "
                + ItemContract.ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +ItemContract.ItemEntry.COLUMN_ITEM_ONE + " TEXT NOT NULL, "
                + ItemContract.ItemEntry.COLUMN_ITEM_TWO + " TEXT NOT NULL,"
                + ItemContract.ItemEntry.COLUMN_ITEM_THREE + " TEXT NOT NULL " + "); ";


        sqLiteDatabase.execSQL(SQLITE_DATABASE_ITEM_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // add items to the db


    public void addItems(Item item){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemContract.ItemEntry.COLUMN_ITEM_ONE, item.getItemOne()); // get item one
        contentValues.put(ItemContract.ItemEntry.COLUMN_ITEM_TWO, item.getItemTwo()); // get item two
        contentValues.put(ItemContract.ItemEntry.COLUMN_ITEM_THREE, item.getItemThree()); // get item three


        db.insert(ItemContract.ItemEntry.TABLE_NAME, null, contentValues);

        db.close(); // close connection

    }


}

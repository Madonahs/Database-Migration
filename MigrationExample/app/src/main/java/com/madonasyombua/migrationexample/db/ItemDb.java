package com.madonasyombua.migrationexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.madonasyombua.migrationexample.db.contracts.ItemContract;

import static com.madonasyombua.migrationexample.db.contracts.ItemContract.ItemEntry.TABLE_NAME;


/**
 * @author madona
 */

public class ItemDb extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "item";
    private static final int DATABASE_VERSION = 1;


    public ItemDb(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ItemContract.ItemEntry.item + " INTEGER PRIMARY KEY," + ItemContract.ItemEntry.item1 + " TEXT,"
                + ItemContract.ItemEntry.item2 + " TEXT" + ")";


        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

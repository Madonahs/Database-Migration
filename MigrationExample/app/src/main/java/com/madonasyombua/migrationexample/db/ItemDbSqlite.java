package com.madonasyombua.migrationexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.madonasyombua.migrationexample.db.contracts.ItemContract;
import com.madonasyombua.migrationexample.db.model.Item;

import static com.madonasyombua.migrationexample.db.contracts.ItemContract.ItemEntry.TABLE_NAME;
import static com.madonasyombua.migrationexample.db.contracts.ItemContract.ItemEntry.item1;


/**
 * @author madona
 */

public class ItemDbSqlite extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "item";
    private static final int DATABASE_VERSION = 1;


    public ItemDbSqlite(Context context){

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

    public void addItems(Item item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.item, item.getItem());
        values.put(ItemContract.ItemEntry.item1, item.getItem_one()); // Contact Phone
        values.put(ItemContract.ItemEntry.item2, item.getItem_two());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public Item getItems(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {ItemContract.ItemEntry.item,
                        item1, ItemContract.ItemEntry.item2}, ItemContract.ItemEntry.item + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
       Item item = new Item(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return item;
    }

}

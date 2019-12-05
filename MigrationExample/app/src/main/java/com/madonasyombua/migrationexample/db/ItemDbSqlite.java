package com.madonasyombua.migrationexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.madonasyombua.migrationexample.db.contracts.ItemContract;
import com.madonasyombua.migrationexample.db.model.Item;
import static com.madonasyombua.migrationexample.db.contracts.ItemContract.ItemEntry.TABLE_NAME;



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

    public void addItems(Item item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ItemContract.ItemEntry.COLUMN_ITEM_ONE, item.getItem());
        values.put(ItemContract.ItemEntry.COLUMN_ITEM_TWO, item.getItem_one());
        values.put(ItemContract.ItemEntry.COLUMN_ITEM_THREE , item.getItem_two());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public Item getItems(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]
                        {ItemContract.ItemEntry.COLUMN_ITEM_ONE,
                        ItemContract.ItemEntry.COLUMN_ITEM_TWO,
                                ItemContract.ItemEntry.COLUMN_ITEM_THREE}, ItemContract.ItemEntry.COLUMN_ITEM_ONE + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        assert cursor != null;
        return new Item(Integer.parseInt(cursor.getString(0)),
                 cursor.getString(1), cursor.getString(2));
    }

}

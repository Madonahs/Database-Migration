package com.madonasyombua.sqliteexample.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.madonasyombua.sqliteexample.R;
import com.madonasyombua.sqliteexample.db.ItemDatabase;
import com.madonasyombua.sqliteexample.db.contracts.ItemContract;
import com.madonasyombua.sqliteexample.ui.adapter.ItemAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author madona
 *
 * Main activity class created 11:23:19
 */
public class MainActivity extends AppCompatActivity {


    private ItemAdapter mAdapter;
    private SQLiteDatabase mDb;


    @BindView(R.id.item_one)
    EditText itemOne;
    @BindView(R.id.item_two)
    EditText itemTwo;
    @BindView(R.id.item_three)
    EditText itemThree;
    @BindView(R.id.item_button)
    Button itemButton;

    //Sqlite
    @BindView(R.id.sql_recylerview)
    RecyclerView sqlRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sqlRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Item database class
        ItemDatabase dbHelper = new ItemDatabase(this);

        mDb = dbHelper.getWritableDatabase(); // get the writable database


        Cursor cursor = getAllItems(); // cursor

        mAdapter = new ItemAdapter(this, cursor); // call the item adapter which has two arguments the context and cursor

        sqlRecyclerView.setAdapter(mAdapter); // set the recycler view to the adapter


    }

    /**
     * Add items to the Sqlite Db Helper
     * @param view item views
     */
    public void addItems(View view){
        if(itemOne.getText().length() == 0 || itemTwo.getText().length() ==0
                || itemThree.getText().length() == 0){
            return;
        }

        // add items to the db this will now show on the recycler view unlike on the video where we just insert
        addNewItems(itemOne.getText().toString(),itemTwo.getText().toString(),itemThree.getText().toString());

        mAdapter.swapCursor(getAllItems());


        itemOne.getText().clear();
        itemTwo.getText().clear();
        itemThree.getText().clear();


    }

    private Cursor getAllItems() {
        return mDb.query(
                ItemContract.ItemEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ItemContract.ItemEntry.COLUMN_ITEM_THREE
        );
    }

    private long addNewItems(String item1, String item2, String item3){

        ContentValues cv = new ContentValues();
        cv.put(ItemContract.ItemEntry.COLUMN_ITEM_ONE, item1);
        cv.put(ItemContract.ItemEntry.COLUMN_ITEM_TWO, item2);
        cv.put(ItemContract.ItemEntry.COLUMN_ITEM_THREE, item3);


        return mDb.insert(ItemContract.ItemEntry.TABLE_NAME, null, cv);
    }

}


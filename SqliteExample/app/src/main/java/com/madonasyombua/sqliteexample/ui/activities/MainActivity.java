package com.madonasyombua.sqliteexample.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.madonasyombua.sqliteexample.R;
import com.madonasyombua.sqliteexample.ui.adapter.ItemAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

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


    }

}


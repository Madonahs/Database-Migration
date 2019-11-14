package com.madonasyombua.roomexample.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.madonasyombua.roomexample.R;
import com.madonasyombua.roomexample.room.db.ItemDatabase;
import com.madonasyombua.roomexample.room.dbhelpers.AppExecutors;
import com.madonasyombua.roomexample.room.dbhelpers.ItemViewModel;
import com.madonasyombua.roomexample.room.entity.Item;
import com.madonasyombua.roomexample.ui.adapter.ItemAdapter;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author madona
 * Main activity class with the floating button and the recycler view which displays data
 * from Add item activity class
 */

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    @BindView(R.id.main_recyclerview)
    RecyclerView mainRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    private ItemDatabase mDb;

    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        ItemAdapter itemAdapter = new ItemAdapter();
        mainRecyclerView.setAdapter(itemAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(linearLayoutManager);



        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.getListLiveData().observe(this, itemAdapter::setItemList);

        // swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AppExecutors.getInstance().diskIO().execute(() -> {
                    int position = viewHolder.getAdapterPosition();
                    List<Item> items =itemAdapter.getItems();
                    mDb.itemDao().deleteItem(items.get(position));
                });
            }
        }).attachToRecyclerView(mainRecyclerView);


        mDb = ItemDatabase.getDatabase(getApplicationContext());

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });


    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {


            Item item = new Item(data.getStringExtra(AddItemActivity.EXTRA_REPLAY),
                    data.getStringExtra(AddItemActivity.EXTRA_REPLAY2),
                    data.getStringExtra(AddItemActivity.EXTRA_REPLAY3));
            itemViewModel.insert(item);


        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
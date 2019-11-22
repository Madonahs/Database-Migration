package com.madonasyombua.sqliteexample.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madonasyombua.sqliteexample.R;
import com.madonasyombua.sqliteexample.db.contracts.ItemContract;
import com.madonasyombua.sqliteexample.db.models.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    //for the sqlite DB hold on to the cursor to display the itemList
    private Cursor cursor;

    private List<Item> itemList;

    private Context mContext;


    public ItemAdapter () {


    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_items, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }




    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.display_item_one)
        TextView displayItemOne;
        @BindView(R.id.display_item_two)
        TextView displayItemTwo;
        @BindView(R.id.display_item_three)
        TextView displayItemThree;


        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}

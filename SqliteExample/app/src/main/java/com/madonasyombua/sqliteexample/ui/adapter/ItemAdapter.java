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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author madona
 *
 * Item Adapter  class created 11:23:19
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private Cursor cursor;
    private Context context;


    /**
     * The Item Adapter Constructor using the context and the db cursor
     * @param mContext calling activity
     * @param mCursor the db cursor to display data
     */
    public ItemAdapter(Context mContext, Cursor mCursor){
        this.context = mContext;
        this.cursor = mCursor;


    }

    /**
     * Item adapter View Holder
     * @param parent parent view group
     * @param viewType view type
     * @return view
     */

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_items, parent, false);

        return new ItemViewHolder(view);
    }

    /**
     * Binding view holder
     * @param holder the item view holder
     * @param position each position
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {


        if(!cursor.moveToPosition(position))
            return;

        String itemOne = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_ITEM_ONE));
        String itemTwo = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_ITEM_TWO));
        String itemThree = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_ITEM_THREE));


        //display item list content
        holder.displayItemOne.setText(itemOne);
        holder.displayItemTwo.setText(itemTwo);
        holder.displayItemThree.setText(itemThree);


    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    /**
     * Swaps the Cursor currently held in the adapter with a new one
     * and triggers a UI refresh
     *
     * @param newCursor the new cursor that will replace the existing one
     */
    public void swapCursor(Cursor newCursor) {

        // Always close the previous mCursor first
        if (cursor != null) cursor.close();

        cursor = newCursor;

        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
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

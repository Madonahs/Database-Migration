package com.madonasyombua.roomexample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madonasyombua.roomexample.R;
import com.madonasyombua.roomexample.room.entity.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author madona
 *
 * The item adapter class which hold items for the recylerview on the main activity screen
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {



    private List<Item> itemList; //to hold list of items

    public ItemAdapter(){

    }


    /**
     * the item view holder which returns the view
     * @param parent parent
     * @param viewType view type
     * @return view
     */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_items,parent,false);
        return new ItemViewHolder(view);
    }

    /**
     * the on bind view holder which hooks the view and positions
     * @param holder holder
     * @param position position
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {


        holder.displayItemOne.setText(itemList.get(position).getItem_one()); // get item one
        holder.displayItemTwo.setText(itemList.get(position).getItem_two()); // get item two
        holder.displayItemThree.setText(itemList.get(position).getItem_three()); // get item three


    }



    public List<Item> getItems() {
        return itemList;
    }

    public void setItemList(List<Item> itemList1){
        itemList = itemList1;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(itemList != null)
            return itemList.size();
        else return 0;


    }

    // the item view holder class which extends a recycler view . view holder
    class ItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.display_item_one)
        TextView displayItemOne;
        @BindView(R.id.display_item_two)
        TextView displayItemTwo;
        @BindView(R.id.display_item_three)
        TextView displayItemThree;


        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
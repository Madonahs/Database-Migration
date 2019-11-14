package com.madonasyombua.roomexample.room.dbhelpers;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.madonasyombua.roomexample.room.dao.ItemDao;
import com.madonasyombua.roomexample.room.db.ItemDatabase;
import com.madonasyombua.roomexample.room.entity.Item;

import java.util.List;

/**
 * @author madona
 * The executor class takes the item dao and the item database and uses the
 * ASyncTask to load the inserted data
 */

class ItemExecutor {

    private final ItemDao itemDao;

    private final LiveData<List<Item>> itemLiveData;

    //constructor which holds application
    ItemExecutor(Application application){

        ItemDatabase itemDatabase = ItemDatabase.getDatabase(application);
        itemDao = itemDatabase.itemDao();
        itemLiveData = itemDao.getAllItems();

    }

    //live data list
    LiveData<List<Item>> getListLiveData(){

        return  itemLiveData;
    }

    // insert method to the async task

    void insert(Item item){

        new insertAsyncTask(itemDao).execute(item);
    }


    private  static class insertAsyncTask extends AsyncTask<Item, Void , Void>{

        private final ItemDao mAsyncTaskDao;

        insertAsyncTask(ItemDao dao){

            mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(Item... items) {

            mAsyncTaskDao.insertItem(items[0]);
            return null;
        }
    }
}

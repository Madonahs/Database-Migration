package com.madonasyombua.roomexample.room.dbhelpers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.madonasyombua.roomexample.room.entity.Item;

import java.util.List;

/**
 * @author madona syombua
 *
 * this class works with the item executor class and livedata
 *
 */
public class ItemViewModel extends AndroidViewModel {

    private ItemExecutor executor;

    private LiveData<List<Item>> listLiveData;

    public ItemViewModel(@NonNull Application application) {
        super(application);

        executor = new ItemExecutor(application);
        listLiveData = executor.getListLiveData(); //get list of live data

    }


    public LiveData<List<Item>> getListLiveData(){

        return listLiveData;
    }

    public  void insert (Item item){

        executor.insert(item);
    }
}

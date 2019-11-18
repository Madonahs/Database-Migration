package com.madonasyombua.roomexample;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import androidx.room.Room;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.madonasyombua.roomexample.room.dao.ItemDao;
import com.madonasyombua.roomexample.room.db.ItemDatabase;
import com.madonasyombua.roomexample.room.entity.Item;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static junit.framework.TestCase.assertTrue;


@RunWith(AndroidJUnit4.class)
public class CreateItemDaoTest {

    //Rule start
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private ItemDao itemDao; // item dao class

    private ItemDatabase itemDatabase; // item room database


    @Before
    public void databaseCreation(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        itemDatabase = Room.inMemoryDatabaseBuilder(context, ItemDatabase.class)
                .allowMainThreadQueries()
                .build();

        itemDao = itemDatabase.itemDao();

    }

    //close database test
    @After
    public void closeTheDatabase(){

        itemDatabase.close();
    }


    //test insert and get items

    @Test
    public void insertAndGetItems() throws InterruptedException{

        Item item = new Item("test 1", "test 2", "test 3");
        itemDao.insertItem(item);

        Item item1 = new Item ("test 4", "test 5", "test 5");
        itemDao.insertItem(item1);

        List<Item> allItems = LiveDataTestUtil.getValue(itemDao.getAllItems());
        assertThat(allItems.size(), is(2));

    }


    // when empty
    @Test
    public void whenEmpty() throws InterruptedException {
        List<Item> items = LiveDataTestUtil.getValue(itemDao.getAllItems());
        assertTrue(items.isEmpty());
    }




}

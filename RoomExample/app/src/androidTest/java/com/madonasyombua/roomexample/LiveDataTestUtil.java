package com.madonasyombua.roomexample;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author madona syombua
 */

public class LiveDataTestUtil {

    static <T> T getValue(final LiveData<T> tLiveData) throws InterruptedException{

        final Object[] data = new Object[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);


        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T t) {
                data[0] = t;
                countDownLatch.countDown();
                tLiveData.removeObserver(this);
            }
        };


        tLiveData.observeForever(observer);
        countDownLatch.await(2, TimeUnit.SECONDS);




        return (T) data[0];
    }

}

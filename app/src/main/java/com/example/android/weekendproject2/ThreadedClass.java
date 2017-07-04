package com.example.android.weekendproject2;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import static android.content.ContentValues.TAG;

/**
 * Created by Android on 7/3/2017.
 */

public class ThreadedClass implements Runnable {
    boolean running;
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public ThreadedClass(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

        do {
            EventBus.getDefault().post(new Messages("Time:" + count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: "+ count);
            count++;

        }while (running);


    }
}

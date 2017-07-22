package com.yossisegev.architecturecomponents;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Yossi Segev on 22/07/2017.
 */

public class CounterThread extends Thread {

    private boolean running;
    private int count;
    private Handler mainHandler;
    private CounterListener counterListener;

    public CounterThread(int initialCount, CounterListener counterListener) {
        mainHandler = new Handler(Looper.getMainLooper());
        this.counterListener = counterListener;
        this.count = initialCount;
    }

    @Override
    public void run() {
        running = true;
        while (running && !isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                stopCounting();
            }
            notifyCount();
        }
    }

    private void notifyCount() {

        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                if (counterListener != null) {
                    counterListener.onCount(count ++);
                }
            }
        });
    }

    public int getCurrentCount() {
        return count;
    }

    public void stopCounting() {
        counterListener = null;
        running = false;
    }

    public interface CounterListener {
        void onCount(int currentCount);
    }
}


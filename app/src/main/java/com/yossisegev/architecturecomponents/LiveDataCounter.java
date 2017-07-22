package com.yossisegev.architecturecomponents;

import android.arch.lifecycle.LiveData;

/**
 * Created by Yossi Segev on 22/07/2017.
 */

public class LiveDataCounter extends LiveData<Integer> implements CounterThread.CounterListener {

    private static class SingletonHolder {
        static final LiveDataCounter INSTANCE = new LiveDataCounter();
    }
    private CounterThread counterThread;
    private int storedCount;

    private LiveDataCounter() { }

    public static LiveDataCounter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    protected void onActive() {
        super.onActive();
        counterThread = new CounterThread(storedCount, this);
        counterThread.start();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        if (counterThread.isAlive()) {
            counterThread.stopCounting();
        }
    }

    @Override
    public void onCount(int currentCount) {
        storedCount = currentCount;
        setValue(currentCount);
    }
}

package com.yossisegev.architecturecomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.Nullable;

/**
 * Created by Yossi Segev on 20/07/2017.
 */

public class LifecycleObserverCounter implements LifecycleObserver {

    private static class InstanceHolder {
        static final LifecycleObserverCounter INSTANCE = new LifecycleObserverCounter();
    }

    private CounterThread counterThread;
    private CounterThread.CounterListener counterListener;
    private int storedCount;

    public static LifecycleObserverCounter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private LifecycleObserverCounter() { }

    public void addCounterListener(@Nullable CounterThread.CounterListener counterListener) {
        this.counterListener = counterListener;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void start() {
        counterThread = new CounterThread(storedCount, counterListener);
        counterThread.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stop() {
        storedCount = counterThread.getCurrentCount();
        if (counterThread.isAlive()) {
            counterThread.stopCounting();
        }
        counterListener = null;
    }
}

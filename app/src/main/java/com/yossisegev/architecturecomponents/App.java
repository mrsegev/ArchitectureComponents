package com.yossisegev.architecturecomponents;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Yossi Segev on 20/07/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}

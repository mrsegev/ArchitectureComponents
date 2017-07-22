package com.yossisegev.architecturecomponents.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yossisegev.architecturecomponents.CounterThread;
import com.yossisegev.architecturecomponents.LifecycleObserverCounter;
import com.yossisegev.architecturecomponents.R;

public class LifecycleObserverActivity extends LifecycleActivity implements CounterThread.CounterListener {

    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counterTextView = findViewById(R.id.current_count);
        LifecycleObserverCounter counter = LifecycleObserverCounter.getInstance();
        counter.addCounterListener(this);
        getLifecycle().addObserver(counter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCount(int currentCount) {
        counterTextView.setText(Integer.toString(currentCount));
    }
}

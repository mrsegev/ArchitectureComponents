package com.yossisegev.architecturecomponents.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yossisegev.architecturecomponents.LiveDataCounter;
import com.yossisegev.architecturecomponents.R;

public class LiveDataActivity extends LifecycleActivity {

    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counterTextView = findViewById(R.id.current_count);

        LiveDataCounter liveDataCounter = LiveDataCounter.getInstance();
        liveDataCounter.observe(this, new Observer<Integer>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null) {
                    counterTextView.setText(Integer.toString(integer));
                }
            }
        });
    }
}

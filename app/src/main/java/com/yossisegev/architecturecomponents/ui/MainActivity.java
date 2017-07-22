package com.yossisegev.architecturecomponents.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.squareup.haha.perflib.Main;
import com.yossisegev.architecturecomponents.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.lifecycle_observer_btn).setOnClickListener(this);
        findViewById(R.id.livedata_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.lifecycle_observer_btn:
                startActivity(new Intent(MainActivity.this, LifecycleObserverActivity.class));
                break;

            case R.id.livedata_btn:
                startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
                break;
        }
    }
}

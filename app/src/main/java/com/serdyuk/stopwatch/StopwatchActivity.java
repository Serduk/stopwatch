package com.serdyuk.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StopwatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    public void onClickStart(View view) {
        System.out.println("Clicked!");
    }

    public void onClickStop(View view) {
        System.out.println("Clicked!");
    }

    public void onClickReset(View view) {
        System.out.println("Clicked!");
    }
}

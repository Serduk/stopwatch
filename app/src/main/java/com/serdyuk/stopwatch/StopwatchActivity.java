package com.serdyuk.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends Activity {
    private int seconds = 0;
    private boolean isRuning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    public void onClickStart(View view) {
        isRuning = true;
    }

    public void onClickStop(View view) {
        isRuning = false;
    }

    public void onClickReset(View view) {
        isRuning = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        int hours = seconds/3600;
        int minutes = (seconds%3600)/60;
        int secs = seconds%60;

        String time = String.format("%d:%02d:%02d", hours, minutes, secs);

        timeView.setText(time);

        if (isRuning) {
            seconds++;
        }
    }
}

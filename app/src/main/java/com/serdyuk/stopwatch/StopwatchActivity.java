package com.serdyuk.stopwatch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends Activity {
    private int seconds = 0;
    private boolean isRunning = false;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        /*
         * Check conditional.
          * If bundle something have -> add this to param
         * */
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    /**
     * Method for saving app states
     * And then, you can send this states in any method. for example: onCreate()
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("isRunning", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }
//
//    /**
//     * When app go to stop: timer should be stopped
//     * */
//    @Override
//    public void onStop() {
//        super.onStop();
//        wasRunning = isRunning;
//        isRunning = false;
//    }
//
//    /**
//     * When app is active: timer should work again
//     * */
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (wasRunning) {
//            isRunning = true;
//        }
//    }

    /**
     * When app go to stop: timer should be stopped
     * */
    @Override
    public void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    /**
     * When app is active: timer should work again
     * */
    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    public void onClickStart(View view) {
        isRunning = true;
    }

    public void onClickStop(View view) {
        isRunning = false;
    }

    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                @SuppressLint("DefaultLocale")
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);

                if (isRunning) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}

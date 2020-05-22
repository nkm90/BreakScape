package com.example.breakscape;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Timer extends AbsActivity{
    static String teamName;
    static long time = 3600000;
    TextView timer;
    static int totalAttempts;

    public void startTimer(){
        time -= (120000*totalAttempts);
        if (timer != null) {
            new CountDownTimer(time-1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    time = millisUntilFinished;
                    setTime(millisUntilFinished);
                }

                public void onFinish() {
                    timer.setText("You Lose!");
                    //switch to game over page
                }
            }.start();
        }
    }


    private void setTime(long milliseconds){
        long newTime = milliseconds / 1000;
        long minutes = newTime /60;
        long secs = newTime %60;
        setTimeText(minutes, secs);
    }
    private void setTimeText(long m, long s){
        if(s<10) {
            timer.setText(m + ":0" + s);
        }
        else{
            timer.setText(m +":"+ s);
        }
    }

}

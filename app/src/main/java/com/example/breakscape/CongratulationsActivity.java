package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CongratulationsActivity extends AbsActivity {
    long time;
    int attempts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        Button send = (Button) findViewById(R.id.review);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home(v);
            }
        });
        //Fetch Attempts and time
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            time = extra.getLong("time");
            attempts = extra.getInt("attempts");
        }

        showFinalScore();


    }

    private void showFinalScore() {
        TextView finalScore = findViewById(R.id.finalTime);
        TextView attemptsBox = findViewById(R.id.attempts);
        finalScore.setText(setTime());
        attemptsBox.setText(""+attempts);

    }

    private String setTime(){
        Log.i("time", ""+time);
        long newTime = (3600000 - time)/1000;  //calculate time taken to complete task
        long minutes = newTime /60;
        long secs = newTime %60;
        return setTimeText(minutes, secs);
    }

    private String setTimeText(long m, long s){
        if(s<10) {
           return (m + ":0" + s);
        }
        else{
            return (m +":"+ s);
        }
    }


    public void send(View view){
        //This needs to be implemented to display or send the reviews.
        //Intent intent = new Intent(this, CongratulationsActivity.class);
        //startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}

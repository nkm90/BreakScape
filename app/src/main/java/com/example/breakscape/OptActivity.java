package com.example.breakscape;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView;

public abstract class OptActivity extends Timer{
    private boolean page1Showing = true;
    private Button pgSwitch;
    private LinearLayout inputArea;
    private LinearLayout nav;


    public void next(){
        TextView pg1 =  findViewById(R.id.pg1);
        TextView pg2 =  findViewById(R.id.pg2);
        inputArea = findViewById(R.id.input);
        nav = findViewById(R.id.align);
        Log.e("Help" , "im here");
        if(page1Showing){
            pg1.setVisibility(View.INVISIBLE);
            pg2.setVisibility(View.VISIBLE);
            inputArea.setVisibility(View.VISIBLE);
            inputArea.setTranslationY(20);
            timer.setTranslationY(20);
            nav.setTranslationY(50);
            pgSwitch.setText("Previous Page");
            page1Showing = false;
        }
        else{
            pg2.setVisibility(View.INVISIBLE);
            inputArea.setVisibility(View.INVISIBLE);
            nav.setTranslationY(-50);
            timer.setTranslationY(-20);
            pg1.setVisibility(View.VISIBLE);
            pgSwitch.setText("Next Page");
            page1Showing = true;
        }
    }
    public void home(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void setClickListeners(){
        timer = findViewById(R.id.Timer);
        pgSwitch = (Button) findViewById(R.id.next);
        pgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home(v);
            }
        });
    }
}

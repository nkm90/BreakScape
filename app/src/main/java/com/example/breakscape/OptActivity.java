package com.example.breakscape;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public abstract class OptActivity extends AbsActivity{
    private boolean page1Showing = true;
    private Button pgSwitch;



    public void next(){
        TextView pg1 =  findViewById(R.id.pg1);
        TextView pg2 =  findViewById(R.id.pg2);
        Log.e("Help" , "im here");
        if(page1Showing){
            pg1.setVisibility(View.INVISIBLE);
            pg2.setVisibility(View.VISIBLE);
            pgSwitch.setText("Previous Page");
            page1Showing = false;
        }
        else{
            pg2.setVisibility(View.INVISIBLE);
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

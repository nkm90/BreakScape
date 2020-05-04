package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(v);
            }
        });
        Button leaders = (Button) findViewById(R.id.leaders);
        leaders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaders(v);
            }
        });
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit(v);
            }
        });


    }
    public void start(View view){
        Intent intent = new Intent(this, IntroActivity.class);
        this.finish();
        startActivity(intent);
    }
    public void leaders(View view){
        Intent intent = new Intent(this, LeadersActivity.class);
        startActivity(intent);
    }
    public void exit(View view){
        finish();
    }
}

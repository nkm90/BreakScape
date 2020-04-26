package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opt3Activity extends AbsRuntimePermission {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt3);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
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

    public void next(View view){
        //posible continuation of the explanation task
        //Intent intent = new Intent(this, CongratulationsActivity.class);
        //startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
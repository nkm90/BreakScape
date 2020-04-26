package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CongratulationsActivity extends AbsRuntimePermission {

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

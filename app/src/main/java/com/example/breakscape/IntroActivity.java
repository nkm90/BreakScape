package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntroActivity extends Timer {
    TextView warning;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(v);
            }
        });

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home(v);
            }
        });

        input = findViewById(R.id.teamName);


        //Hide warning of invalid team name
        warning  = (TextView) findViewById(R.id.warning);
        warning.setVisibility(View.INVISIBLE);

    }

    public void start(View view) {
        teamName = input.getText().toString();
        if (checkValidName()){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else{
            warning.setVisibility(View.VISIBLE);
        }
    }

    private boolean checkValidName() {
        return teamName.length() > 0;
    }

    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}

package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class IntroActivity extends AbsRuntimePermission {
    TextView warning;
    EditText teamName;

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

        teamName = findViewById(R.id.teamName);


        //Hide warning of invalid team name
        warning  = (TextView) findViewById(R.id.warning);
        warning.setVisibility(View.INVISIBLE);

    }

    public void start(View view) {
        if (checkValidName()){
            Intent intent = new Intent(this, MenuActivity.class);
            String name = teamName.getText().toString();
            intent.putExtra("teamName", name);
            startActivity(intent);
        }
        else{
            warning.setVisibility(View.VISIBLE);
        }
    }

    private boolean checkValidName() {
        return teamName.getText().length() > 0;
    }

    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}

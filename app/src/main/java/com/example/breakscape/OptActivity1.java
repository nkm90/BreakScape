package com.example.breakscape;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptActivity1 extends OptActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateCode();
        populateHintNumber();
        setContentView(R.layout.activity_opt1);
        setSolved(getIntent().getExtras().getBoolean("pageSolved"));
        setUpElements();
        addPropertyChangeListener(new MenuActivity());

        Button game = (Button) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game(v);
            }
        });
    }

    public void game(View view){
        Intent intent = new Intent(this, Phishing.class);
        startActivity(intent);
    }

    @Override
    public void populateCode() {
        setCode("1345");
    }

    @Override
    public void populateHintNumber(){
        setHintNumber(3);
    }


}

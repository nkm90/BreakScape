package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.beans.PropertyChangeListener;

public class OptActivity3 extends OptActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt3);
        setCode();
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
        Intent intent = new Intent(this, EncryptionActivity.class);
        startActivity(intent);
    }
    @Override
    public void setCode() {
        code = "7528";
    }
}

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
        populateCode();
        populateHintNumber();
        setSolved(getIntent().getExtras().getBoolean("pageSolved"));
        setUpElements();
        addPropertyChangeListener(new MenuActivity());

    }
    @Override
    public void populateCode() {
        setCode("1345");
    }

    @Override
    public void populateHintNumber(){
        setHintNumber(0);

    }
}

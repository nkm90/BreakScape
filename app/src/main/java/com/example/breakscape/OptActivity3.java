package com.example.breakscape;

import android.os.Bundle;

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

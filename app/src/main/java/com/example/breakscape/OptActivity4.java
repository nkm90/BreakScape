package com.example.breakscape;

import android.os.Bundle;

import java.beans.PropertyChangeListener;

public class OptActivity4 extends OptActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt4);
        setCode();
        setSolved(getIntent().getExtras().getBoolean("pageSolved"));
        setUpElements();
        addPropertyChangeListener(new MenuActivity());

    }

    @Override
    public void setCode() {
        code = "1234";
    }


}

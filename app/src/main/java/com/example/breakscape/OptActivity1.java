package com.example.breakscape;

import android.os.Bundle;

public class OptActivity1 extends OptActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCode();
        setContentView(R.layout.activity_opt1);
        setSolved(getIntent().getExtras().getBoolean("pageSolved"));
        setUpElements();
        addPropertyChangeListener(new MenuActivity());





    }

    @Override
    public void setCode() {
        code = "1345";
    }
}

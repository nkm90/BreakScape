package com.example.breakscape;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class OptActivity extends Timer  {
    private boolean page1Showing = true;
    private Button pgSwitch;
    private LinearLayout inputArea;
    private LinearLayout nav;
    private List<EditText> inputs;
    private String code;
    private boolean solved;

    private PropertyChangeSupport support;



    public void setUpElements() {
        inputArea = findViewById(R.id.input);
        nav = findViewById(R.id.align);
        timer = findViewById(R.id.Timer);
        pgSwitch = (Button) findViewById(R.id.next);
        code = "1234";
        support = new PropertyChangeSupport(this);
        setInputs();
        setClickListeners();
        startTimer();

        if (!solved){
            checkCodeEverySec();

        }
        else{
            codeCorrect();
        }
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }


    public void next(){
        TextView pg1 =  findViewById(R.id.pg1);
        TextView pg2 =  findViewById(R.id.pg2);

        Log.e("Help" , "im here");
        if(page1Showing){
            pg1.setVisibility(View.INVISIBLE);
            pg2.setVisibility(View.VISIBLE);
            inputArea.setVisibility(View.VISIBLE);
            inputArea.setTranslationY(20);
            timer.setTranslationY(20);
            nav.setTranslationY(50);
            pgSwitch.setText("Previous Page");
            page1Showing = false;
        }
        else{
            pg2.setVisibility(View.INVISIBLE);
            inputArea.setVisibility(View.INVISIBLE);
            nav.setTranslationY(-50);
            timer.setTranslationY(-20);
            pg1.setVisibility(View.VISIBLE);
            pgSwitch.setText("Next Page");
            page1Showing = true;
        }
    }
    public void home(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void setClickListeners(){

        pgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
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

    public void checkCodeEverySec(){
        if (timer != null) {
            new CountDownTimer(time, 1000) {

                public void onTick(long millisUntilFinished) {
                    checkCode();
                }

                public void onFinish() {

                }
            }.start();
        }

    }

    protected void checkCode(){
        for( int i=0; i < inputs.size(); i++){

            String text = inputs.get(i).getText().toString();
            if(text.length() > 0){
                char c = text.charAt(0);
                if(c != code.charAt(i)) return;
            }

        }
        codeCorrect();
    }

    private void codeCorrect(){
        int i =0;
        for (EditText et:inputs) {
            char[] c = new char[1];
            c [0] = code.charAt(i);
            et.setTextColor(Color.RED);
            et.setFocusable(false);
            et.setText(c, 0, 1);
            i++;

        }

        support.firePropertyChange(getClass().toString(), this.solved, true);
        solved = true;

    }

    protected void setInputs(){
        inputs = new ArrayList<>();
        for (int i =0; i < 4; i++){
            EditText txt = (EditText) inputArea.getChildAt(i);
            inputs.add(txt);
        }
    }

    public boolean getSolved(){
        return solved;
    }

    public void setSolved(boolean solve){
        solved =solve;
    }


}

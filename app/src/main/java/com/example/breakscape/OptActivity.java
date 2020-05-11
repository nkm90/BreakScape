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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class OptActivity extends Timer  {
    private boolean page1Showing = true;
    private Button pgSwitch;
    private LinearLayout inputArea;
    private LinearLayout nav;
    List<EditText> inputs;
    private String code;
    private int hintNumber;
    private boolean solved;


    private PropertyChangeSupport support;

    //set up all the elements immediately after onCreate method
    public void setUpElements() {
        inputArea = findViewById(R.id.input);
        nav = findViewById(R.id.align);
        timer = findViewById(R.id.Timer);
        pgSwitch = (Button) findViewById(R.id.next);
        support = new PropertyChangeSupport(this);
        setInputs();
        setClickListeners();
        startTimer();
        checkIfPageIsSolved();
    }

    private void checkIfPageIsSolved(){
        if (!solved){
            checkCodeEverySec();
        }
        else{
            pageAlreadySolved();
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    //Each option activity needs to set own code
    public abstract void populateCode();
    //Hint number indicates the number to break final code - Color is set to green
    public abstract void populateHintNumber();

    public void setClickListeners(){
        pgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPages();
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

    public void home(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }


    public void switchPages(){
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




    //check code every 500ms to see if it has been solved
    public void checkCodeEverySec(){
        if (timer != null) {
            new CountDownTimer(time, 500) {
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
                if(text.charAt(0) != code.charAt(i)) return;
            }else{
                return;
            }
        }
        codeCorrect();
    }

    //if code is correct format text and fire property change listener to MenuActivity
    private void codeCorrect(){
        for (int i= 0; i < inputs.size(); i++) {
            textFormatOnceSolved(inputs.get(i),i);
        }
        support.firePropertyChange(getClass().toString(), this.solved, true);
        solved = true;
    }

    private void textFormatOnceSolved(EditText et, int index){
        if(index == hintNumber) {
            et.setTextColor(Color.GREEN);
        }
        else{
            et.setTextColor(Color.RED);
        }
        et.setFocusable(false);
    }

    //Page has already been solved. Set text to correct code and format to show it has been solved
    void pageAlreadySolved(){
        for (int i= 0; i < inputs.size(); i++) {
            char[] c = new char[1];
            c [0] = code.charAt(i);
            inputs.get(i).setText(c, 0, 1);
            textFormatOnceSolved(inputs.get(i), i);

        }
    }

    //set up edit text boxes - for code input - into an ArrayList
    private void setInputs(){
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

    public void setCode(String newCode){
        code = newCode.substring(0,4);
    }

    public void setHintNumber(int newHintNumber){
        hintNumber = newHintNumber;
    }

}

package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class MenuActivity extends Timer implements PropertyChangeListener{

    private static boolean option1Solved;
    private static boolean option2Solved;
    private static boolean option3Solved;
    private static boolean option4Solved;

    ImageView imgTick1;
    ImageView imgTick2;
    ImageView imgTick3;
    ImageView imgTick4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //linking the breakscape button to a variable to set the listener for click interations.
        Button resolve = (Button) findViewById(R.id.breakscape);
        resolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolve(v);
            }
        });
        //Linking the button to return to the main menu
        Button home =  (Button) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home(v);
            }
        });
        //Linking each of the options on the menu with another listener
        Button op1 = (Button) findViewById(R.id.option1);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1(v);
            }
        });
        Button op2 = (Button) findViewById(R.id.option2);
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2(v);
            }
        });
        Button op3 = (Button) findViewById(R.id.option3);
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option3(v);
            }
        });
        Button op4 = (Button) findViewById(R.id.option4);
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option4(v);
            }
        });
        timer = findViewById(R.id.Timer);
        startTimer();
        setUpImages();

    }

    private void setUpImages() {
        imgTick1 = findViewById(R.id.tick1);
        imgTick2 = findViewById(R.id.tick2);
        imgTick3 = findViewById(R.id.tick3);
        imgTick4 = findViewById(R.id.tick4);
    }

    //Resolve method open the activity to the final window to provide the answer to the game
    public void resolve(View view){
        Intent intent = new Intent(this, BreakActivity.class);

        startActivity(intent);
    }
    //Home method just returns home and finish game. maybe worthy to find a double confirmation
    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
    //Method to open the activity of the option 1 of the menu
    public void option1(View view) {
        Intent intent = new Intent(this, Opt1Activity.class);
        startIntent(intent, option1Solved);
    }
    //Method to open the activity of the option 2 of the menu
    public void option2(View view){
        Intent intent = new Intent(this, Opt2Activity.class);
        startIntent(intent, option2Solved);
    }
    //Method to open the activity of the option 3 of the menu
    public void option3(View view){
        Intent intent = new Intent(this, Opt3Activity.class);
        startIntent(intent, option3Solved);
    }
    //Method to open the activity of the option 4 of the menu
    public void option4(View view){
        Intent intent = new Intent(this, Opt4Activity.class);
        startIntent(intent, option4Solved);
    }

    public void startIntent(Intent intent, boolean pageSolved){

        if (pageSolved){
            intent.putExtra("pageSolved", true);
        }
        else{
            intent.putExtra("pageSolved", false);
        }
        startActivity(intent);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String s = (evt.getPropertyName());
        setPageSolved(s.charAt(s.length()-1), (boolean) evt.getNewValue());
    }

    private void setPageSolved(char pgNum, boolean value){
    switch (pgNum){

        case'1':
            option1Solved=value;
            break;
        case'2':
            option2Solved=value;
            break;
        case'3':
            option3Solved=value;
            break;
        case'4':
            option4Solved=value;
            break;


        }
}


}

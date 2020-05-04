package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class MenuActivity extends Timer implements PropertyChangeListener{

    private static boolean option1Solved;
    private static boolean option2Solved;
    private static boolean option3Solved;
    private static boolean option4Solved;

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
        ImageView imgTick1 = findViewById(R.id.tick1);
        ImageView imgTick2 = findViewById(R.id.tick2);
        ImageView imgTick3 = findViewById(R.id.tick3);
        ImageView imgTick4 = findViewById(R.id.tick4);
        ImageView imgBox1 = findViewById(R.id.box1);
        ImageView imgBox2 = findViewById(R.id.box2);
        ImageView imgBox3 = findViewById(R.id.box3);
        ImageView imgBox4 = findViewById(R.id.box4);

        boxOrTick(imgTick1, imgBox1, option1Solved);
        boxOrTick(imgTick2, imgBox2, option2Solved);
        boxOrTick(imgTick3, imgBox3, option3Solved);
        boxOrTick(imgTick4, imgBox4, option4Solved);


    }
    //switch the images depending if the task has been completed
    private void boxOrTick(ImageView imgViewTick, ImageView imgViewBox, boolean bool){
        if(bool){
            imgViewTick.setVisibility(View.VISIBLE);
            imgViewBox.setVisibility(View.INVISIBLE);
        }
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
        Intent intent = new Intent(this, OptActivity1.class);
        startIntent(intent, option1Solved);
    }
    //Method to open the activity of the option 2 of the menu
    public void option2(View view){
        Intent intent = new Intent(this, OptActivity2.class);
        startIntent(intent, option2Solved);
    }
    //Method to open the activity of the option 3 of the menu
    public void option3(View view){
        Intent intent = new Intent(this, OptActivity3.class);
        startIntent(intent, option3Solved);
    }
    //Method to open the activity of the option 4 of the menu
    public void option4(View view){
        Intent intent = new Intent(this, OptActivity4.class);
        startIntent(intent, option4Solved);
    }
    //send intent with info as to whether the page has already been solved
    public void startIntent(Intent intent, boolean pageSolved){

        if (pageSolved){
            intent.putExtra("pageSolved", true);
        }
        else{
            intent.putExtra("pageSolved", false);
        }

        startActivity(intent);
    }

    //Listen to OptActivity class - if variable solved has been changed set the relevant option to be solved
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String s = (evt.getPropertyName());
        setPageSolved(s.charAt(s.length()-1), (boolean) evt.getNewValue());
    }

    //Depending on page solved set relevant boolean(option1solved, option2solved etc...)
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

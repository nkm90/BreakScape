package com.example.breakscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BreakActivity extends Timer {
    private LinearLayout inputArea;
    String inputs;
    //This
    EditText num1;
    EditText num2;
    EditText num3;
    EditText num4;
    private String code = "7044";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);

        startTimer();


        Button check = (Button) findViewById(R.id.enter);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(v);
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

    public void check(View view){
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();
        String input3 = num3.getText().toString();
        String input4 = num4.getText().toString();

        if(input1.equals("7") && input2.equals("0") && input3.equals("4") && input4.equals("4")){
            //if the answer provided is correct, congratulations activity will appear
            Intent intent = new Intent(this, CongratulationsActivity.class);
            startActivity(intent);
            this.finish();
        }else {
            totalAttempts++;
        }

    }
    public void home(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}

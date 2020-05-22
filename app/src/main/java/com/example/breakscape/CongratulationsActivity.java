package com.example.breakscape;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CongratulationsActivity extends AbsActivity {
    long time;
    int attempts;
    String teamName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        Button send = (Button) findViewById(R.id.review);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home(v);
            }
        });
        //Fetch Attempts and time
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            time = extra.getLong("time");
            attempts = extra.getInt("attempts");
            teamName = extra.getString("teamName");
        }

        String ft = showFinalScore();
        Log.d("SSSSSSSSSSSSSSSSS", "This is the time: " + ft);
        // update congratulations message with teamname "textView28"
        // also, need to create a global variable like this:
        // https://www.codeproject.com/tips/611985/global-variable-in-android
        // and use it to store that "teamName" variable (line 46 on introactivity.java)

        ryan(teamName, ft);
    }

    private String showFinalScore() {
        TextView finalScore = findViewById(R.id.finalTime);
        TextView attemptsBox = findViewById(R.id.attempts);
        finalScore.setText(setTime());
        attemptsBox.setText(""+attempts);
        return finalScore.getText().toString();
    }

    private String setTime(){
        Log.i("time", ""+time);
        long newTime = (3600000 - time)/1000;  //calculate time taken to complete task
        long minutes = newTime /60;
        long secs = newTime %60;
        return setTimeText(minutes, secs);
    }

    private String setTimeText(long m, long s){
        if(s<10) {
           return (m + ":0" + s);
        }
        else{
            return (m +":"+ s);
        }
    }

    public void ryan(final String teamName, final String solvedTime) {
        class ryan extends AsyncTask<String, String, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            protected String doInBackground(String... args) {
                HttpURLConnection connection;
                OutputStreamWriter request = null;
                URL url = null;
                String response = null;
                String parameters = "team_name="+teamName+"&solved_time="+solvedTime;
                try {
                    url = new URL("http://192.168.1.73/breakscape/add_score.php");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setRequestMethod("POST");

                    request = new OutputStreamWriter(connection.getOutputStream());
                    request.write(parameters);
                    request.flush();
                    request.close();
                    String line = "";
                    InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                    BufferedReader reader = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    // Response from server after login process will be stored in response variable.
                    response = sb.toString();
                    isr.close();
                    reader.close();
                }
                catch(IOException e)
                {
                    // Error
                }
                return "";
            }

            protected void onPostExecute(String file_url) {}
        }
        ryan ryan = new ryan();
        ryan.execute(teamName, solvedTime);
    }

    public void send(View view){
        //This needs to be implemented to display or send the reviews.
        //Intent intent = new Intent(this, CongratulationsActivity.class);
        //startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}

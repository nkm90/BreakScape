package com.example.breakscape;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeadersActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // ryan added this below
        // try putting code here//////////////////////////////////////////
        downloadJSON("http://192.168.1.73/breakscape/read_scores.php");
        ///////////////////////////////////////////////////////////////////

        Button check = (Button) findViewById(R.id.backBtn);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainMenu(v);
            }
        });

    }

    // new fnc

    private void downloadJSON(final String urlWebService) {
        class DownloadJSON extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return "";
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }

    // new fnc

    private void loadIntoListView(String str) throws JSONException {
        JSONArray jsonArray = new JSONArray(str);
        String[] stocks = new String[jsonArray.length()];
        // pos #1
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText("1");
        textView = (TextView)findViewById(R.id.textView3);
        textView.setText((jsonArray.getJSONObject(0)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView4);
        textView.setText((jsonArray.getJSONObject(0)).getString("solved_time"));
        // pos #2
        textView = (TextView)findViewById(R.id.textView5);
        textView.setText("2");
        textView = (TextView)findViewById(R.id.textView6);
        textView.setText((jsonArray.getJSONObject(1)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView7);
        textView.setText((jsonArray.getJSONObject(1)).getString("solved_time"));
        // pos #3
        textView = (TextView)findViewById(R.id.textView8);
        textView.setText("3");
        textView = (TextView)findViewById(R.id.textView9);
        textView.setText((jsonArray.getJSONObject(2)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView10);
        textView.setText((jsonArray.getJSONObject(2)).getString("solved_time"));
        // pos #4
        textView = (TextView)findViewById(R.id.textView11);
        textView.setText("4");
        textView = (TextView)findViewById(R.id.textView12);
        textView.setText((jsonArray.getJSONObject(3)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView13);
        textView.setText((jsonArray.getJSONObject(3)).getString("solved_time"));
        // pos #5
        textView = (TextView)findViewById(R.id.textView14);
        textView.setText("5");
        textView = (TextView)findViewById(R.id.textView15);
        textView.setText((jsonArray.getJSONObject(4)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView16);
        textView.setText((jsonArray.getJSONObject(4)).getString("solved_time"));
        // pos #6
        textView = (TextView)findViewById(R.id.textView17);
        textView.setText("6");
        textView = (TextView)findViewById(R.id.textView18);
        textView.setText((jsonArray.getJSONObject(5)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView19);
        textView.setText((jsonArray.getJSONObject(5)).getString("solved_time"));
        // pos #7
        textView = (TextView)findViewById(R.id.textView20);
        textView.setText("7");
        textView = (TextView)findViewById(R.id.textView21);
        textView.setText((jsonArray.getJSONObject(6)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView22);
        textView.setText((jsonArray.getJSONObject(6)).getString("solved_time"));
        // pos #8
        textView = (TextView)findViewById(R.id.textView23);
        textView.setText("8");
        textView = (TextView)findViewById(R.id.textView24);
        textView.setText((jsonArray.getJSONObject(7)).getString("team_name"));
        textView = (TextView)findViewById(R.id.textView25);
        textView.setText((jsonArray.getJSONObject(7)).getString("solved_time"));
    }

    public void backToMainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

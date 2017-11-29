package com.example.epulapp.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Mon log","On Create");

       Button button = (Button) findViewById(R.id.button1v1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, JeuActivite.class);
                startActivity(myIntent);
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonFragm);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, ActiviteFragment.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("Mon log","On start");
        super.onStart();

    }
    @Override
    protected void onResume() {
        Log.d("Mon log","On Resume");
        super.onResume();

    }
    @Override
    protected void onPause() {
        Log.d("Mon log","On Pause");
        super.onPause();

    }
    @Override
    protected void onStop() {
        Log.d("Mon log","On Stop");
        super.onStop();

    }
    @Override
    protected void onDestroy() {
        Log.d("Mon log","On Destroy");
        super.onDestroy();

    }


}

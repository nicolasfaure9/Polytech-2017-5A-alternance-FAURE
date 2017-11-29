package com.example.epulapp.lab01;

import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements clickInterface,FragmentPrincipal.OnFragmentInteractionListener, JeuxFragment.OnFragmentInteractionListener {
    BroadcastReceiver receiver;
    IntentFilter filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = new IntentFilter();
        filter.addAction("com.example.SendBroadcast");
        receiver = new MyReceiver();
        registerReceiver(receiver,filter);

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FragmentPrincipal bdf = new FragmentPrincipal();

            ft.replace(R.id.fragment, bdf);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public void buttonClicked() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        JeuxFragment bdf = new JeuxFragment();
        ft.replace(R.id.fragment, bdf);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        ft.commit();
        //Change the UI
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

package com.example.epulapp.lab01;

import android.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.epulapp.lab01.dummy.Biere;

import java.util.List;

public class ActivityBiere extends AppCompatActivity implements BiereClick {
    BroadcastReceiver receiver;
    IntentFilter filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            BiereFragment bdf = new BiereFragment();

            ft.replace(R.id.fragment, bdf);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();

        }

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

    @Override
    public void onItemClick(View view, int position, List<Biere> bieres) {
        Log.d("From Activity","Position : " + position);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        DetailBiereFragment bdf = new DetailBiereFragment();
        bdf.setMaBiere(bieres.get(position));
        ft.replace(R.id.fragment, bdf);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
        //Change the UI
    }


}

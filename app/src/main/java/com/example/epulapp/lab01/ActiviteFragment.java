package com.example.epulapp.lab01;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActiviteFragment extends AppCompatActivity implements clickInterface,FragmentPrincipal.OnFragmentInteractionListener, JeuxFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

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
}

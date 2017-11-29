package com.example.epulapp.lab01;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentPrincipal extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private OnFragmentInteractionListener mListener;

    public FragmentPrincipal() {
        // Required empty public constructor
    }


    public static FragmentPrincipal newInstance(String param1, String param2) {
        FragmentPrincipal fragment = new FragmentPrincipal();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Mon depuis Fragement","On Create");
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Mon depuis Fragement","On CreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) view.findViewById(R.id.button1v1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Log.d("Mon depuis Fragement","On Click");
                // Start NewActivity.class
                FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
                JeuxFragment bdf = new JeuxFragment();
                ft.replace(R.id.fragment, bdf);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                ft.commit();
            }
        });

        return view;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        Log.d("Mon depuis Fragement","On Attach");
        super.onAttach(context); /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        } */
    }

    @Override
    public void onDetach() {
        Log.d("Mon depuis Fragement","On Detach");
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package com.example.epulapp.lab01;

import android.view.View;

import com.example.epulapp.lab01.dummy.Biere;

import java.util.List;

/**
 * Created by Epulapp on 30/11/2017.
 */

public interface BiereClick {

    public void onItemClick(View view, int position, List<Biere> bieres);


}

package com.example.epulapp.lab01;

import com.example.epulapp.lab01.dummy.Biere;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Epulapp on 30/11/2017.
 */

public interface BiereAPI {
    @GET("beers/")
    Call<List<Biere>> getBieres();



}

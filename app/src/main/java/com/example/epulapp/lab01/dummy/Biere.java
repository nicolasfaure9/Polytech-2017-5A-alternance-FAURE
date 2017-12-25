package com.example.epulapp.lab01.dummy;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Epulapp on 29/11/2017.
 */

public class Biere {

    @SerializedName("id")
        public final String id;
    @SerializedName("name")
        public final String name;
    @SerializedName("abv")
    public final String abv;

    @SerializedName("image_url")
    public final String image_url;

    private Bitmap imgBiere;


        public Biere(String id, String content, String abv,String image_url) {
            this.id = id;
            this.name = content;
            this.abv=abv;
            this.image_url=image_url;
        }

        public void setImgBiere(Bitmap img){
            this.imgBiere = img;
        }

        public Bitmap getImgBiere(){
            return this.imgBiere;
        }

    }


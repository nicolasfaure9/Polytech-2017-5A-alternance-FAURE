package com.example.epulapp.lab01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.epulapp.lab01.dummy.Biere;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Epulapp on 04/12/2017.
 */

public class MyDownloadImageAsyncTask extends AsyncTask<String, Void,Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
private Biere biere;
    public MyDownloadImageAsyncTask(ImageView imageView, Biere biere) {
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.biere = biere;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return DownloadBitmap(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }

        if (imageViewReference != null) {
            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                    biere.setImgBiere(bitmap);
                } else {
                    //Drawable placeholder = imageView.getContext().getResources().getDrawable(R.drawable.placeholder);
                    //imageView.setImageDrawable(placeholder);
                }
            }
        }
    }

    private Bitmap DownloadBitmap(String url) {
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(url);
            urlConnection = (HttpURLConnection) uri.openConnection();
            int statusCode = urlConnection.getResponseCode();
            if (statusCode != 200) {
                return null;
            }

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (Exception e) {
            urlConnection.disconnect();

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
}

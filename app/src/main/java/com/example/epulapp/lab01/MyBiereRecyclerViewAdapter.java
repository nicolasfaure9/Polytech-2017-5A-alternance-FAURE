package com.example.epulapp.lab01;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.epulapp.lab01.BiereFragment.OnListFragmentInteractionListener;
import com.example.epulapp.lab01.dummy.Biere;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Biere} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBiereRecyclerViewAdapter extends RecyclerView.Adapter<MyBiereRecyclerViewAdapter.ViewHolder> {

    private final List<Biere> mValues;

    private Context context;
    private int rowLayout;


    public MyBiereRecyclerViewAdapter(List<Biere> items, int rowLayout, Context context) {
        mValues = items;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_biere, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mAbvView.setText(mValues.get(position).abv);
        if (holder.mImage != null) {
            new MyDownloadImageAsyncTask(holder.mImage).execute(mValues.get(position).image_url);
        }

        //AsyncTask<String, Void, Bitmap> task =  new MyDownloadImageAsyncTask().execute(mValues.get(position).image_url);
       // holder.mImage.setImageDrawable(new );

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mNameView;
        public final TextView mAbvView;
        public final ImageView mImage;
        public Biere mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mAbvView = (TextView) view.findViewById(R.id.abv);
            mImage = (ImageView) view.findViewById(R.id.img);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}

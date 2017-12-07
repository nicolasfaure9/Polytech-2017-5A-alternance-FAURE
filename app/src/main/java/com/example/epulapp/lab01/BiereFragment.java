package com.example.epulapp.lab01;

import android.content.Context;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epulapp.lab01.dummy.Biere;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BiereFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private static Retrofit retrofit = null;
    private OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView ;
    private RecyclerView.Adapter mAdapter;
    private BiereClick myClickListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BiereFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BiereFragment newInstance(int columnCount) {
        BiereFragment fragment = new BiereFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biere_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();


           // Runnable runnable = new Runnable() { mAdapter = new MyBiereRecyclerViewAdapter(); recyclerView.setAdapter(mAdapter); }; mRecyclerView.post(runnable);
           // recyclerView.setAdapter(null);
            connectAndGetApiData(context,view);


        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Biere item);
    }

    public void connectAndGetApiData(final Context context,final View view){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        BiereAPI biereApiService = retrofit.create(BiereAPI.class);

        Call<List<Biere>> call = biereApiService.getBieres();
        call.enqueue(new Callback<List<Biere>>() {
            @Override
            public void onResponse(Call<List<Biere>> call, Response<List<Biere>> response) {
                Log.d("OnResponse", "Number of beers received: ");


                final List<Biere> bieres = response.body();

                if (mColumnCount <= 1) {
                    recyclerView = (RecyclerView) view;
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                }
                recyclerView.setAdapter(new MyBiereRecyclerViewAdapter(bieres, R.layout.fragment_biere_list, context));

               // recyclerView.setAdapter(new MyBiereRecyclerViewAdapter(bieres,mListener ));
                Log.d(TAG, "Number of movies received: " + bieres.size());

                recyclerView.addOnItemTouchListener(
                        new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener()  {
                            @Override public void onItemClick(View view, int position) {
                                myClickListener = (BiereClick) getActivity();
                                myClickListener.onItemClick(view,position,bieres);
                            }

                            @Override public void onLongItemClick(View view, int position) {
                                Log.d("LOG CLICK" , String.valueOf(position));
                            }
                        }    )
                );
            }

            @Override
            public void onFailure(Call<List<Biere>> call, Throwable t) {
                Log.d("On Failure", "Erreur " );
            }
        });
    }
}

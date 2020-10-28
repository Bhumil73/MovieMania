package com.bhumil73.moviemania.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bhumil73.moviemania.R;
import com.bhumil73.moviemania.api.API;
import com.bhumil73.moviemania.api.api_movies;
import com.bhumil73.moviemania.models.movie;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    api_movies moviesAPI;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        moviesAPI = new api_movies(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_home, container, false);
        final ListView moviesList = layout.findViewById(R.id.moviesList);

        moviesAPI.listMovies(1, new API.api_callback<List<movie>>() {
            @Override
            public void onResult(List<movie> resultData) {
                List<String> movieNames = new ArrayList<>();
                for (movie m : resultData) movieNames.add(m.title);
                ArrayAdapter<String> movieNamesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, movieNames);
                moviesList.setAdapter(movieNamesAdapter);
            }

            @Override
            public void onError() {
                Toast.makeText(getContext(), "Error connecting to server", Toast.LENGTH_SHORT).show();
            }
        });

        return layout;
    }


}

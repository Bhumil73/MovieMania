package com.bhumil73.moviemania.api;

import android.content.Context;

import com.bhumil73.moviemania.models.api_response;
import com.bhumil73.moviemania.models.movie;
import com.bhumil73.moviemania.models.movies_response;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class api_movies extends API {

    // Constants
    public final String endpoint_listMovies = "https://yts.lt/api/v2/list_movies.json";

    // Constructor
    public api_movies(Context ctx) {
        super(ctx);
    }


    /**
     * API Methods
     */
    public void listMovies(int page, final api_callback<List<movie>> callback) {
        int movies_per_page = 10;
        Map<String, String> params = new HashMap<>();
        params.put("page", Integer.toString(page));
        params.put("limit", Integer.toString(movies_per_page));

        fetch_results(endpoint_listMovies, params, new api_callback<api_response>() {
            @Override
            public void onResult(api_response resultData) throws JSONException {
                movies_response movies_response_data = new movies_response(resultData.data);
                List<movie> movies = movies_response_data.movies;
                callback.onResult(movies);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

}

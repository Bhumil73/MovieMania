package com.bhumil73.moviemania;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

// Movie response object
public class movies_response {

    int movies_count, limit, page_number;

    List< movie > movies;

    movies_response(JSONObject data) throws JSONException {
        this.movies_count = data.getInt("movie_count");
        this.limit = data.getInt("limit");
        this.page_number = data.getInt("page_number");

        JSONArray moviesArray = data.getJSONArray("data");

        // Iterate over json array of data and get object from it
        // create movie obj from it then add it to the list
        for (int i = 0; i < movies.size(); i++) {
            JSONObject MovieJsonObject = moviesArray.getJSONObject(i);
            movie movieObj = new movie(MovieJsonObject);
            this.movies.add(movieObj);
        }
    }

}

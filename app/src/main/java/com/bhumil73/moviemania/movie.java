package com.bhumil73.moviemania;

import org.json.JSONException;
import org.json.JSONObject;

// movie response object POJO
public class movie {
    public static String title, imdb_code, url;
    int id, year, runtime;
    Double rating;

    movie(JSONObject data) throws JSONException {
        this.id = data.getInt("id");
        this.year = data.getInt("year");
        this.runtime = data.getInt("runtime");
        this.rating = data.getDouble("rating");
        this.title = data.getString("title");
        this.imdb_code = data.getString("imdb_code");
        this.url = data.getString("url");

    }

}

package com.bhumil73.moviemania;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.PrecomputedText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class API extends HomeFragment {

    public static String res;
    public class api_movies extends API{

        public final String endpoint_listMovies = "https://yts.lt/api/v2/list_movies.json";
        public List< movie > listMovies(int page) throws JSONException {
            int movies_per_page = 10;
             Map<String,String > params = new Map<String, String>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(@Nullable Object o) {
                    return false;
                }

                @Override
                public boolean containsValue(@Nullable Object o) {
                    return false;
                }

                @Nullable
                @Override
                public String get(@Nullable Object o) {

                    return null;
                }

                @Nullable
                @Override
                public String put(String s, String s2) {
                    return null;
                }

                @Nullable
                @Override
                public String remove(@Nullable Object o) {
                    return null;
                }

                @Override
                public void putAll(@NonNull Map<? extends String, ? extends String> map) {


                }

                @Override
                public void clear() {

                }

                @NonNull
                @Override
                public Set<String> keySet() {
                    return null;
                }

                @NonNull
                @Override
                public Collection<String> values() {
                    return null;
                }

                @NonNull
                @Override
                public Set<Entry<String, String>> entrySet() {

                    return null;
                }

            };
             params.put("page",Integer.toString(page));
             params.put("limit",Integer.toString(movies_per_page));

             api_response response = this.fetch_results(endpoint_listMovies,params);
             movies_response movies_response_data = new movies_response(response.data);

             List<movie> movies = movies_response_data.movies;
            return movies;
        }
    }

    public api_response fetch_results(String endpoints,Map< String ,String > params) throws JSONException {
        Map< String ,String > final_params = new Map<String, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsValue(@Nullable Object o) {
                return false;
            }

            @Nullable
            @Override
            public String get(@Nullable Object o) {
                return null;
            }

            @Nullable
            @Override
            public String put(String s, String s2) {
                return null;
            }

            @Nullable
            @Override
            public String remove(@Nullable Object o) {
                return null;
            }

            @Override
            public void putAll(@NonNull Map<? extends String, ? extends String> map) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set<String> keySet() {
                return null;
            }

            @NonNull
            @Override
            public Collection<String> values() {
                return null;
            }

            @NonNull
            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };
        //adding provided params with finalParams
        final_params.putAll(params);

        //url building with parameters
        String finalUrl = this.buildURL(endpoints,final_params);

        //API Call
        RequestQueue response;

        response = Volley.newRequestQueue(getContext());
        res = response.toString();
        return new api_response(res);

    }
    private String buildURL(String baseURL,Map<String ,String > params){
        Uri.Builder builder = Uri.parse(baseURL).buildUpon();
        for (String key: params.keySet()){
            builder.appendQueryParameter(key,params.get(key));
        }
        return builder.build().toString();
    }

}



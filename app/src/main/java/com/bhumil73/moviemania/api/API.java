package com.bhumil73.moviemania.api;

import android.content.Context;
import android.net.Uri;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bhumil73.moviemania.models.api_response;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class API {

    Context context;

    API(Context ctx) {
        context = ctx;
    }

    public void fetch_results(String endpoints, Map<String, String> params, final api_callback<api_response> callback) {
        Map<String, String> final_params = new HashMap<>();
        //adding provided params with finalParams
        final_params.putAll(params);

        //url building with parameters
        String finalUrl = this.buildURL(endpoints, final_params);

        //API Call
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, finalUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    callback.onResult(new api_response(response));
                } catch (JSONException e) {
                    callback.onError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(2000, 5, 0.1f));
        requestQueue.add(request);
        requestQueue.start();
    }

    private String buildURL(String baseURL, Map<String, String> params) {
        Uri.Builder builder = Uri.parse(baseURL).buildUpon();
        for (String key : params.keySet()) {
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }

    public interface api_callback<T> {
        void onResult(T resultData) throws JSONException;

        void onError();
    }

}



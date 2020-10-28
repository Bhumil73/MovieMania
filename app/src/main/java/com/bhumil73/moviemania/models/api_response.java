package com.bhumil73.moviemania.models;

import org.json.JSONException;
import org.json.JSONObject;

public class api_response {
    public String status, status_message;
    public JSONObject data;
    public boolean is_error;

    public api_response(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        this.status = jsonObject.getString("status");
        this.status_message = jsonObject.getString("status_message");
        this.data = jsonObject.getJSONObject("data");
        this.is_error = !this.status.equals("ok");
    }

}

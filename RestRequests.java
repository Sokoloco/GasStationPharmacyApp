package com.example.luis.gasstationpharmacyapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RestRequests extends Activity {

    public JSONObject sendClient(JSONObject newClient,Context mContext){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        String url = "http://ygjwz.mocklab.io/json/3";
        JSONObject catcher = new JSONObject();
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, newClient, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("The response","There has been a Response");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error sending message","There was an error sending the message");
            }
        });
        requestQueue.add(objectRequest);
        return catcher;
    }
}
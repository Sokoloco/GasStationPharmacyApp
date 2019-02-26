package com.example.luis.gasstationpharmacyapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONHandler {

    public void createUser(String name, String lastName, String id, String residence, String bDate, String numTel, String history, Context mContext){
        Map<String,String> user = new HashMap<>();
        user.put("name",name);
        user.put("lastname",lastName);
        user.put("id",id);
        user.put("bDate",bDate);
        user.put("residence",residence);
        user.put("numTel",numTel);
        user.put("history",history);
        JSONObject newUser = new JSONObject(user);
        RestRequests cliReq = new RestRequests();
        Log.d("JsonHandler Cli","The client has been requested");
        cliReq.sendClient(newUser,mContext);

    }
}

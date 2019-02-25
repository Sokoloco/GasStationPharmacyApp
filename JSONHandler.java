package com.example.luis.gasstationpharmacyapp;

import java.util.HashMap;
import java.util.Map;

public class JSONHandler {

    public void createUser(String name, String lastName, String id, String residence, String bDate, String numTel, String history){
        Map<String,String> user = new HashMap<>();
        user.put("name",name);
        user.put("lastname",lastName);
        user.put("id",id);
        user.put("bDate",bDate);
        user.put("residence",residence);
        user.put("numTel",numTel);
        user.put("history",history);

    }
}

package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getName();

    public static Sandwich parseSandwichJson(String json) {

        try{
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject sandwichName = sandwichJSON.getJSONObject("name");

            String sandwichMainName = sandwichName.getString("mainName");
            String sandwichAKAName = sandwichName.getString("alsoKnownAs");
            String sandwichOrigin = sandwichJSON.getString("placeOfOrigin");
            String sandwichDescription = sandwichJSON.getString("description");
            String sandwichImage = sandwichJSON.getString("image");

            Log.v(TAG, "Sandwich main name : " + sandwichMainName +" AKA name : " + sandwichAKAName + "Origin : "  + sandwichOrigin + " description : " + sandwichDescription + " image : " + sandwichImage);

        }
        catch(JSONException e){
            Log.e( TAG, "Exception", e);
        }

        return null;
    }
}

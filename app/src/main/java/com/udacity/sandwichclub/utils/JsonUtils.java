package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getName();

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject sandwichName = sandwichJSON.getJSONObject("name");

            String sandwichMainName = sandwichName.getString("mainName");
            String sandwichOrigin = sandwichJSON.getString("placeOfOrigin");
            String sandwichDescription = sandwichJSON.getString("description");
            String sandwichImage = sandwichJSON.getString("image");

            JSONArray sandwichAKAName = sandwichName.getJSONArray("alsoKnownAs");
            JSONArray sandwichIngredients = sandwichJSON.getJSONArray("ingredients");

            List<String> AKAList = new ArrayList<>();
            for (int i = 0; i < sandwichAKAName.length(); i++) {
                AKAList.add(sandwichAKAName.getString(i));
            }

            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < sandwichIngredients.length(); i++) {
                ingredientsList.add(sandwichIngredients.getString(i));
            }

            // Logging - set just for testing
            //Log.v(TAG, "Sandwich main name : " + sandwichMainName + " AKA name : " + AKAList + " ingredients : " + ingredientsList + "Origin : " + sandwichOrigin + " description : " + sandwichDescription + " image : " + sandwichImage);

            Sandwich chosenSandwich = new Sandwich(sandwichMainName, AKAList, sandwichOrigin, sandwichDescription, sandwichImage, ingredientsList);
            return chosenSandwich;
        } catch (JSONException e) {
            Log.e(TAG, "Exception", e);
        }

        return null;
    }
}

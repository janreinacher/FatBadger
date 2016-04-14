package com.example.student.fatbadger.Restaurant_Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by student on 4/13/16.
 */
public class searchResultsModel {
    @SerializedName("businesses")
    ArrayList<restaurantModel> searchResults;

    public ArrayList<restaurantModel> getSearchResults() {
        return searchResults;
    }
}

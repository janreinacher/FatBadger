package com.example.student.fatbadger.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by student on 4/13/16.
 */
public class SearchResultsModel {
    @SerializedName("businesses")
    ArrayList<restaurantModel> searchResults;

    public ArrayList<restaurantModel> getSearchResults() {
        return searchResults;
    }
}

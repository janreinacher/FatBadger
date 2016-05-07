package com.example.student.fatbadger.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by student on 4/13/16.
 */
public class SearchResultsModel {
    @SerializedName("businesses")
    ArrayList<RestaurantModel> searchResults;

    public ArrayList<RestaurantModel> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<RestaurantModel> searchResults) {
        this.searchResults = searchResults;
    }
}

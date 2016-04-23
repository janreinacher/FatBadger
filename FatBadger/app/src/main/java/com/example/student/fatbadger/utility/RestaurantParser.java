package com.example.student.fatbadger.utility;

import com.google.gson.Gson;
import com.example.student.fatbadger.model.SearchResultsModel;

/**
 * Created by Shay on 4/23/16.
 */
public class RestaurantParser {
    public static final SearchResultsModel parseRestaurantFromJson(final String inputString) {
        SearchResultsModel searchResultsModel;
        Gson gson = new Gson();
        searchResultsModel = gson.fromJson(inputString, SearchResultsModel.class);

        return searchResultsModel;
    }
}

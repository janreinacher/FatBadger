package com.example.student.fatbadger.Utility;

import com.google.gson.Gson;
import 

/**
 * Created by student on 4/13/16.
 */
public class yelpParser {
    public static final searchResultsModel parseRecipeFromJson(final String inputString) {
        searchResultsModel SearchResultsModel;
        Gson gson = new Gson();
        searchResultsModel = gson.fromJson(inputString, searchResultsModel.class);

        return SearchResultsModel;
}

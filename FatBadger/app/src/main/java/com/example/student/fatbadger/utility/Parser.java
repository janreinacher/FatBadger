package com.example.student.fatbadger.utility;

import com.google.gson.Gson;
import com.example.student.fatbadger.model.SearchResultsModel;

/**
 * Created by student on 4/13/16.
 */
public class Parser {
    public static final SearchResultsModel parseFromJson(final String inputString) {
        SearchResultsModel SearchResultsModel;
        Gson gson = new Gson();
        SearchResultsModel = gson.fromJson(inputString, com.example.student.fatbadger.model.SearchResultsModel.class);

        return SearchResultsModel;
    }
}

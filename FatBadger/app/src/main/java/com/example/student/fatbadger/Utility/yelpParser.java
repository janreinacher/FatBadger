package com.example.student.fatbadger.Utility;

import com.example.student.fatbadger.DataMock.RandomMockData;
import com.google.gson.Gson;
import com.example.student.fatbadger.model.SearchResultsModel;

/**
 * Created by student on 4/13/16.
 */

public class yelpParser {
    private String inputString;

    //public insertData () {
           // for (int i =0;i < 3; i++ ) {
            //        inputString = RandomMockData.MockStringArray[i];

          //  }

   // }

    public static final SearchResultsModel parseRecipeFromJson(final String inputString) {
        SearchResultsModel SearchResultsModel;
        Gson gson = new Gson();
        SearchResultsModel = gson.fromJson(inputString, com.example.student.fatbadger.model.SearchResultsModel.class);

        return SearchResultsModel;
    }
}

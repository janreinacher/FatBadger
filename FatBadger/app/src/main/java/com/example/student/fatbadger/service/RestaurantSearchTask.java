package com.example.student.fatbadger.service;

/**
 * Created by Shay on 4/23/16.
 */

import android.os.AsyncTask;

import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.RestaurantParser;
import com.example.student.fatbadger.utility.UrlFormatUtility;
import com.example.student.fatbadger.listener.RestaurantCallbackListener;

import java.io.IOException;

public class RestaurantSearchTask {

    private RestaurantCallbackListener restaurantCallbackListener;

    public RestaurantSearchTask (final RestaurantCallbackListener restaurantCallbackListener){
        this.restaurantCallbackListener = restaurantCallbackListener;
    }

    @Override
    protected SearchResultsModel doInBackground(String... params) {
        HttpRequestManager httpRequestManager = new HttpRequestManager();
        String response ="";

        try {
            response = httpRequestManager.getRestaurant(UrlFormatUtility.formatRestaurantSearchString(params[0]));
        }
        catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return RestaurantParser.parseRestaurantFromJson(response);
    }

    @Override
    protected void onPostExecute(SearchResultsModel searchResultsModel){
        super.onPostExecute(searchResultsModel);
        restaurantCallbackListener.onSearchCallback(searchResultsModel);
    }
}

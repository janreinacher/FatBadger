package com.example.student.fatbadger.service;

import android.os.AsyncTask;

import com.example.student.fatbadger.listener.CallbackListener;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.yelpParser;
import com.example.student.fatbadger.service.api.ApiClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Jackson on 4/14/16.
 */
public class SearchTask extends AsyncTask<String,String,SearchResultsModel> {

    private CallbackListener callBackListener;
    public SearchTask (final CallbackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    @Override
    protected SearchResultsModel doInBackground(String... params) {
        String response = "";
        try {
            response = ApiClient.getInstance().getUrl(params[0]);
        } catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return yelpParser.parseRecipeFromJson(response);
    }

    @Override
    protected void onPostExecute(SearchResultsModel searchResultsModel) {
        super.onPostExecute(searchResultsModel);
        // Invoke the local listener which has a referece to the concretely implemented listener in SearchActivity
        callBackListener.onSearchCallback(searchResultsModel);
    }
}

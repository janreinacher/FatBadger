package com.example.student.fatbadger.service;

import android.os.AsyncTask;

import com.example.student.fatbadger.listener.CallbackListener;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.YelpParser;
import com.example.student.fatbadger.utility.UrlFormatUtility;


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
        HttpRequestManager httpRequestManager = new HttpRequestManager();
        String response = "";
        try {
            response = httpRequestManager.getUrl(UrlFormatUtility.formatSearchString(params[0]));
        } catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return YelpParser.parseFromJson(response);
    }
}

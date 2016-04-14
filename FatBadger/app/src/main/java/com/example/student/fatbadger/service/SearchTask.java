package com.example.student.fatbadger.service;

import android.os.AsyncTask;

import com.example.student.fatbadger.service.api.HttpRequestManager;
import java.io.IOException;
import com.example.student.fatbadger.listener.CallbackListener;

/* import Richard's part
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.Parser;
import com.example.student.fatbadger.utility.UrlFormatUtility;
*/

/**
 * Created by Jackson on 4/14/16.
 */
public class SearchTask extends AsyncTask<String,String,SearchResultsModel> {

    private CallbackListener callBackListener;
    public SearchTask (final CallbackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    /* Depends on resultsModel, urlFormatUtility, and Parser
    @Override
    protected SearchResultsModel doInBackground(String... params) {
        HttpRequestManager httpRequestManager = new HttpRequestManager();
        String response = "";
        try {
            response = httpRequestManager.getUrl(UrlFormatUtility.formatSearchString(params[0]));
        } catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return Parser.parseFromJson(response);
    }
    */

}

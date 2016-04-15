package com.example.student.fatbadger.listener;

import com.example.student.fatbadger.Restaurant_Model.SearchResultsModel;

/**
 * A simple interface to allow implementation of a Listener pattern for managing notification
 * of completed background threaded tasks managed by the SearchTask
 */
public interface CallbackListener {
    void onSearchCallback(SearchResultsModel searchResultsModel);
}

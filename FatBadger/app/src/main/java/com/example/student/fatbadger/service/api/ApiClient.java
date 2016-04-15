package com.example.student.fatbadger.service.api;

import com.example.student.fatbadger.viewcontroller.AppDefines;
import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit.Call;

/**
 * Created by student on 4/13/16.
 */
public class ApiClient {

    private static ApiClient instance;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    private YelpAPIFactory apiFactory;
    private YelpAPI yelpAPI;

    public void CreateAPI() {

        apiFactory = new YelpAPIFactory(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET, AppDefines.TOKEN, AppDefines.TOKEN_SECRET);
        yelpAPI = apiFactory.createAPI();
    }

    public Call<SearchResponse> call(Map<String, String> params, String searchString) {

        return yelpAPI.search(searchString, params);
    }
}

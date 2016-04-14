package com.example.student.fatbadger.service.api;

import com.example.student.fatbadger.viewcontroller.AppDefines;
import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;

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

    // YelpAPIFactory(String consumerKey, String consumerSecret, String token, String tokenSecret)
    private YelpAPIFactory apiFactory = new YelpAPIFactory(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET, AppDefines.TOKEN, AppDefines.TOKEN_SECRET);
    private YelpAPI yelpAPI = apiFactory.createAPI();

    Map<String, String> params = new HashMap<>();
    {
        // general params
        params.put("term", "food");
        params.put("limit", "20");
    }

    //Call<SearchResponse> call = yelpAPI.search("San Francisco", params);
}

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

    // YelpAPIFactory(String consumerKey, String consumerSecret, String token, String tokenSecret)
    private YelpAPIFactory apiFactory;
    private YelpAPI yelpAPI;

    public String getUrl() throws IOException {
        apiFactory = new YelpAPIFactory(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET, AppDefines.TOKEN, AppDefines.TOKEN_SECRET);
        yelpAPI = apiFactory.createAPI();
        Map<String, String> params = new HashMap<>();
        {
            // general params
            params.put("term", "food");
            params.put("limit", "20");
        }
        Call<SearchResponse> call = yelpAPI.search("San Francisco", params);
        retrofit.Response<SearchResponse> response = call.execute();
        String url = response.body().toString();
        return url;
    }
}

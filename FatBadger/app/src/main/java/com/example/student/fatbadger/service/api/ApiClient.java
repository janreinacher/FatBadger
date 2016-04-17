
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
    private Map<String, String> params;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    private YelpAPIFactory apiFactory;
    private YelpAPI yelpAPI;

    public void CreateAPI() {
        params = new HashMap<>();
        {
            // general params
            params.put("term", "food");
            params.put("limit", "20");
        }
        apiFactory = new YelpAPIFactory(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET, AppDefines.TOKEN, AppDefines.TOKEN_SECRET);
        yelpAPI = apiFactory.createAPI();
    }

    public String getUrl(String searchString) throws IOException {

        Call<SearchResponse> call = yelpAPI.search(searchString, params);
        retrofit.Response<SearchResponse> response = call.execute();
        String url = response.body().toString();
        return url;
    }

    public void addParam(String key, String value) {
        params.put(key,value);
    }
}
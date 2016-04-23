
package com.example.student.fatbadger.service.api;

import com.example.student.fatbadger.viewcontroller.AppDefines;
//import com.yelp.clientlib.connection.YelpAPI;
//import com.yelp.clientlib.connection.YelpAPIFactory;
//import com.yelp.clientlib.entities.SearchResponse;
import com.example.student.fatbadger.service.adapter.RestaurantApiAdapter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import retrofit.Call;

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

    //private YelpAPIFactory apiFactory;
    //private YelpAPI yelpAPI;


    public RestaurantApiAdapter getRestaurantApiAdapter() {
        //CreateAPI();
        RestaurantApiAdapter api = new Retrofit.Builder()
                .baseUrl(AppDefines.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RestaurantApiAdapter.class);

        return api;
    }

/*
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

    public SearchResponse getSearchResponse(String searchString) throws IOException {

        Call<SearchResponse> call = yelpAPI.search(searchString, params);
        retrofit.Response<SearchResponse> response = call.execute();
        SearchResponse searchResponse = response.body();

        return searchResponse;
    }

    public void addParam(String key, String value) {
        params.put(key,value);
    }
    */
}
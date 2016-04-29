
package com.example.student.fatbadger.service.api;

import android.util.Log;

import com.example.student.fatbadger.viewcontroller.AppDefines;
//import com.yelp.clientlib.connection.YelpAPI;
//import com.yelp.clientlib.connection.YelpAPIFactory;
//import com.yelp.clientlib.entities.SearchResponse;
import com.example.student.fatbadger.service.adapter.RestaurantApiAdapter;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;
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
        YelpOAuthConsumer consumer = new YelpOAuthConsumer(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET);
        consumer.setTokenWithSecret(AppDefines.TOKEN, AppDefines.TOKEN_SECRET);
        consumer.generateNonce();
        String s = "";

//        try {
//            String uuid = UUID.randomUUID().toString();
//            consumer.sign(uuid);
//        } catch(Exception e) {
//            if(e.getClass().isAssignableFrom(OAuthCommunicationException.class)){
//                s = ((OAuthCommunicationException)e).getResponseBody();
//            } else if(e.getClass().isAssignableFrom(OAuthExpectationFailedException.class)) {
//                s = ((OAuthExpectationFailedException)e).getMessage();
//            } else if(e.getClass().isAssignableFrom(OAuthMessageSignerException.class)) {
//                s = ((OAuthMessageSignerException)e).getMessage();
//            }

            Log.d("OH SHIT", s);
//        }


        OkHttpClient client  = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        RestaurantApiAdapter api = new Retrofit.Builder()
                .baseUrl(AppDefines.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
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
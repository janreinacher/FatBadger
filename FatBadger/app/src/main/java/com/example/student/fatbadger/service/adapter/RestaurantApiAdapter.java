package com.example.student.fatbadger.service.adapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.example.student.fatbadger.model.SearchResultsModel;

public interface RestaurantApiAdapter {

    @GET ("v2/search")
    Observable<SearchResultsModel> getSearchResults(
        @Query("term") String searchString,
        @Query("oauth_consumer_key") String consumerKey,
        @Query("oauth_consumer_secret") String consumerSecret,
        @Query("oauth_token") String token,
        @Query("oauth_token_secret") String tokenSecret);
}
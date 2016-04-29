package com.example.student.fatbadger.service.adapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.example.student.fatbadger.model.SearchResultsModel;

import java.sql.Timestamp;

public interface RestaurantApiAdapter {

    @GET ("v2/search")
    Observable<SearchResultsModel> getSearchResults(
        @Query("term") String searchString,
        @Query("oauth_consumer_key") String consumerKey,
        @Query("oauth_consumer_secret") String consumerSecret,
        @Query("oauth_token") String token,
        @Query("oauth_token_secret") String tokenSecret,
        @Query("oauth_signature_method") String signatureMethod,
        @Query("oauth_signature") String signature,
        @Query("oauth_timestamp") Timestamp timestamp,
        @Query("oauth_nonce") String nonce);
}
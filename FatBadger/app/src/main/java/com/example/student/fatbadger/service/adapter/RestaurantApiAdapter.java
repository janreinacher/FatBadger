package com.example.student.fatbadger.service.adapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.example.student.fatbadger.model.SearchResultsModel;

public interface RestaurantApiAdapter {

    @GET ("v2/search")
    Observable<SearchResultsModel> getSearchResults(
        @Query("term_key") String term,
        @Query("term_secret") String termSecret,
        @Query("token") String token,
        @Query("token_secret") String tokenSecret,
        @Query("q") String searchString);
}
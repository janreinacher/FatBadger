package com.example.student.fatbadger.service.adapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.example.student.fatbadger.model.SearchResultsModel;

public interface RestaurantApiAdapter {

    @GET ("v2/search")
    Observable<SearchResultsModel> getSearchResults(
        @Query("term") String searchString);
}
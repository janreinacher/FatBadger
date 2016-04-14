package com.example.student.fatbadger.service.adapter;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
//import com.example.student.fatbadger.model.SearchResultsModel;

public interface SearchApiAdapter {

    @GET("v2/search")
    Observable<SearchResultsModel> getRecipeSearchResults(
            // General Search Params
            @Query("term") String term,
            @Query("limit") String limit,
            @Query("offset") String offset,
            @Query("sort") String sort,
            @Query("category_filter") String category_filter,
            @Query("radius_filter") String radius_filter,
            @Query("deals_filter") String deals_filter,
            // Location Params
            @Query("location") String location,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude
    );
};

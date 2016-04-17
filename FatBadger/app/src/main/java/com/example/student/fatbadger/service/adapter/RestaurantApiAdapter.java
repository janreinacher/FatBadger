package com.example.student.fatbadger.service.adapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.example.student.fatbadger.model.SearchResultsModel;

public interface RestaurantApiAdapter {

    Observable<SearchResultsModel> getSearchResults();
}
package com.example.student.fatbadger.Activity_Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.fatbadger.R;
import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.SearchResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit.Call;


/**
 * Created by The Janitor on 4/5/16.
 */
public class searchActivity extends AppCompatActivity {
    private YelpAPI yelpAPI;
    private YelpAPIFactory apiFactory;
    private EditText searchText;
    private Button searchButton;
    private RecyclerView RestaurantRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        apiFactory = new YelpAPIFactory("b9XjaVT2lGL8Z2lh2qzvpg", "XLGu0hiT-F-Vtz2cUMXnxDzM1rw", "XqGF2hUZXeNbZn8Vcx1cmpHtAHoLDKB-", "hxtwtRh3uaQN9kFos-n7_x3W5m4");
        yelpAPI = apiFactory.createAPI();
        searchText = (EditText)findViewById(R.id.searchText);
        searchButton= (Button)findViewById(R.id.searchButton);
        RestaurantRecyclerView = (RecyclerView)findViewById(R.id.RestaurantRecyclerView);
    }


    Map<String, String> params = new HashMap<>();

    {
        // general params
        params.put("term", "food");
        params.put("limit", "3");
    }


   Call<SearchResponse> call = yelpAPI.search("San Francisco", params);

}

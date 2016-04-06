package com.example.student.fatbadger.Activity_Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.fatbadger.R;


/**
 * Created by The Janitor on 4/5/16.
 */
public class searchActivity extends AppCompatActivity {
    private EditText searchText;
    private Button searchButton;
    private RecyclerView RestaurantRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchText = (EditText)findViewById(R.id.searchText);
        searchButton= (Button)findViewById(R.id.searchButton);
        RestaurantRecyclerView = (RecyclerView)findViewById(R.id.RestaurantRecyclerView);
    }


}

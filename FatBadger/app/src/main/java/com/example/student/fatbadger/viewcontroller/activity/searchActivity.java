package com.example.student.fatbadger.viewcontroller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.fatbadger.fragment.*;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;


/**
 * Created by The Janitor on 4/5/16.
 */
public class searchActivity extends AppCompatActivity {

    private SearchFragment searchFragment;
    private BusinessFragment businessFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnFragmentEvent(new SearchFragment.OnFragmentEvent() {
            @Override
            public void onEvent(RestaurantModel restaurant) {
                businessFragment = BusinessFragment.newInstance(restaurant);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, businessFragment)
                        .addToBackStack(BusinessFragment.class.getSimpleName())
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, searchFragment)
                .addToBackStack(SearchFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onDestroy() { super.onDestroy(); }
}

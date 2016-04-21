package com.example.student.fatbadger.viewcontroller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.fatbadger.R;
import com.example.student.fatbadger.viewcontroller.fragment.SearchFragment;
import com.example.student.fatbadger.viewcontroller.fragment.RestaurantFragment;
import com.yelp.clientlib.entities.Business;


/**
 * Created by The Janitor on 4/5/16.
 */
public class searchActivity extends AppCompatActivity {
    private SearchFragment searchFragment;
    private  RestaurantFragment restaurantFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnFragmentEvent(new SearchFragment.OnFragmentEvent() {
            @Override
            public void onEvent(Business restaurantModel) {
                restaurantFragment = RestaurantFragment.newInstance(restaurantModel);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, restaurantFragment)
                        .addToBackStack(RestaurantFragment.class.getSimpleName())
                        .commit();
            }

        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, searchFragment)
                .addToBackStack(SearchFragment.class.getSimpleName())
                .commit();
    }
    @Override
    protected void onDestroy() {super.onDestroy();}
}

package com.example.student.fatbadger.viewcontroller.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.viewcontroller.fragment.SearchFragment;
import com.example.student.fatbadger.viewcontroller.fragment.RestaurantFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


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
            public void onEvent(RestaurantModel restaurantModel) {
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            //case R.id.convenience:
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

package com.example.student.fatbadger.viewcontroller.fragment;

/**
 * Created by Jan on 5/5/16.
 */

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;


import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.RestaurantParser;
import com.example.student.fatbadger.viewHolder.RestaurantAdapter;


public class BlockedFragment extends Fragment {

    private Button editButton;
    private RecyclerView restaurantRecyclerView;
    private RestaurantAdapter adapter;
    private LinearLayoutManager layoutManager;


}

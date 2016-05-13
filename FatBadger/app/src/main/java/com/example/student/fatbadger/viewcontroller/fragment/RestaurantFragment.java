package com.example.student.fatbadger.viewcontroller.fragment;

/**
 * Created by Shay on 4/13/16.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.service.api.ApiClient;


public class RestaurantFragment extends Fragment {
    private RestaurantModel model;
    private static final String RESTAURANT = "restaurant";

    private ImageView detailThumbnail;
    private TextView detailName;
    private TextView phone;
    private TextView address;
    private TextView hours;
    private ToggleButton favorite;
    private ToggleButton blocked;
    //private TextView distance;

    public RestaurantFragment() {

    }

    public static RestaurantFragment newInstance(RestaurantModel model) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putSerializable(RESTAURANT, model);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);

        if( getArguments() != null)
            model = (RestaurantModel)getArguments().getSerializable(RESTAURANT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        detailThumbnail = (ImageView)view.findViewById(R.id.restaurantDetailThumbnail);
        detailName = (TextView)view.findViewById(R.id.restaurantDetailName);
        phone = (TextView)view.findViewById(R.id.restaurantPhone);
        address = (TextView)view.findViewById(R.id.restaurantAddress);
        hours = (TextView)view.findViewById(R.id.restaurantHours);
        favorite = (ToggleButton)view.findViewById(R.id.restaurantFavorites);
        favorite.setTextOn("Unfavorite");
        favorite.setTextOff("Favorite");
        if (model.getFavorite())
            favorite.setText(favorite.getTextOn());
        else
            favorite.setText(favorite.getTextOff());
        favorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // the toggle is enabled
                    model.setFavorite(true);
                } else {
                    // the toggle is disabled
                    model.setFavorite(false);
                }
            }
        });
        blocked = (ToggleButton)view.findViewById(R.id.restaurantBlocked);
        blocked.setTextOn("Unblock");
        blocked.setTextOff("Block");
        if (model.getBlocked())
            blocked.setText(blocked.getTextOn());
        else
            blocked.setText(blocked.getTextOff());
        blocked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // the toggle is enabled
                    model.setBlocked(true);
                } else {
                    // the toggle is disabled
                    model.setBlocked(false);
                }
            }
        });
        //distance = (TextView)view.findViewById(R.id.restaurantDistance);

        Glide.with(this).load(model.getImg_url())
                .into(detailThumbnail);

        detailName.setText(model.getName());
        phone.setText(model.getDisplayPhone());
        address.setText(model.getDisplayAddress());
        hours.setText(model.getHours());
        //distance.setText(model.getDistance());
        return view;
    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}
}

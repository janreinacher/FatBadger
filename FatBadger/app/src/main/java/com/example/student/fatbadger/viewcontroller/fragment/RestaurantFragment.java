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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.student.fatbadger.R;

import com.example.student.fatbadger.model.RestaurantModel;

public class RestaurantFragment extends Fragment {
    private RestaurantModel restaurant;
    private static final String Restaurant = "restaurant";

    private ImageView restaurantDetailThumbnail;
    private TextView restaurantDetailName;
    private ListView details;

    public RestaurantFragment() {

    }

    public static RestaurantFragment newInstance(RestaurantModel restaurant) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putSerializable(Restaurant, restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);

        if( getArguments() != null)
            restaurant = (RestaurantModel)getArguments().getSerializable(Restaurant);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        restaurantDetailThumbnail = (ImageView)view.findViewById(R.id.restaurantDetailThumbnail);
        restaurantDetailName = (TextView)view.findViewById(R.id.restaurantDetailName);
        details = (ListView)view.findViewById(R.id.description);

        Glide.with(this).load(restaurant.getImg_url())
                .into(restaurantDetailThumbnail);

        restaurantDetailName.setText(restaurant.getName());

        // details.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, restaurant.getDetails()));

        return view;


    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}
}

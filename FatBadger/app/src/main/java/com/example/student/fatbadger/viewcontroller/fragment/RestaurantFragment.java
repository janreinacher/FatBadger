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
import com.yelp.clientlib.entities.Business;

public class RestaurantFragment extends Fragment {
    private Business business;
    private static final String Business = "business";

    private ImageView detailThumbnail;
    private TextView detailName;
    private ListView details;

    public RestaurantFragment() {

    }

    public static RestaurantFragment newInstance(Business business) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putSerializable(Business, business);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);

        if( getArguments() != null)
            business = (Business)getArguments().getSerializable(Business);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        detailThumbnail = (ImageView)view.findViewById(R.id.restaurantDetailThumbnail);
        detailName = (TextView)view.findViewById(R.id.restaurantDetailName);
        details = (ListView)view.findViewById(R.id.description);

        Glide.with(this).load(business.imageUrl())
                .into(detailThumbnail);

        detailName.setText(business.name());

        // details.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, restaurant.getDetails()));

        return view;


    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}
}

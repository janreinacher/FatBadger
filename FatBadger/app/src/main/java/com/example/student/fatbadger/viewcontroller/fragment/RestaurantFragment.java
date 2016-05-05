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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;


public class RestaurantFragment extends Fragment {
    private RestaurantModel model;
    private static final String RESTAURANT = "restaurant";

    private ImageView detailThumbnail;
    private TextView detailName;
    private TextView phone;
    private TextView address;

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

        Glide.with(this).load(model.getImg_url())
                .into(detailThumbnail);

        detailName.setText(model.getName());
        phone.setText(model.getDisplayPhone());
        // Code below not working, found errors in ListView earlier
        address.setText((CharSequence) model.getDisplayAddress());
        return view;
    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}
}

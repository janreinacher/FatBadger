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

public class RestaurantFragment extends Fragment {
    private static final String Restaurant = "restaurant";

    private ImageView restaurantDetailThumbnail;
    private TextView recipeDetailName;
    private ListView description;

    public RestaurantFragment() {

    }

}

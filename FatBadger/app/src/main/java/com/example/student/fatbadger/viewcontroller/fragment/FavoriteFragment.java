package com.example.student.fatbadger.viewcontroller.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.service.api.ApiClient;
import com.example.student.fatbadger.viewHolder.RestaurantAdapter;

import java.sql.Timestamp;

/**
 * Created by Grady on 5/11/2016.
 */
public class FavoriteFragment extends Fragment {
    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;
    private LinearLayoutManager linearLayoutManager;
    private OnFragmentEvent onFragmentEvent;
    private SearchResultsModel searchResultsModel;
    private TextView titleFavorite;

    public FavoriteFragment() {
        // Constructor
    }

    public static FavoriteFragment newInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Drawable FatBadger = getResources().getDrawable(R.drawable.fatbadger);
        FatBadger.setAlpha(50);
    }

    public Timestamp getTimestamp(){
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(date.getTime());
        return currentTimestamp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.favoritesRecyclerView);
        titleFavorite = (TextView)view.findViewById(R.id.titleFavorites);
        titleFavorite.setText(R.string.favorites);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        searchResultsModel = ApiClient.getInstance().getFavoriteRestaurants();

        if (searchResultsModel != null && searchResultsModel.getSearchResults().size() > 0) {
            restaurantAdapter = new RestaurantAdapter(searchResultsModel.getSearchResults());
            restaurantAdapter.setOnItemSelected(new RestaurantAdapter.OnItemSelected() {
                @Override
                public void onSelected(RestaurantModel item) {
                    if (onFragmentEvent != null) {
                        onFragmentEvent.onEvent(item);
                    }
                }
            });
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(restaurantAdapter);
        }

        return view;
    }
    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}

    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }

    public interface OnFragmentEvent {
        void onEvent(RestaurantModel itemModel);
    }
}

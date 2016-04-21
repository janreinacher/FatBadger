package com.example.student.fatbadger.viewcontroller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.service.adapter.RestaurantApiAdapter;
import com.example.student.fatbadger.viewHolder.RestaurantAdapter;
import com.example.student.fatbadger.service.api.ApiClient;
import com.yelp.clientlib.entities.SearchResponse;
import com.yelp.clientlib.entities.Business;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import rx.Observer;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;

/**
 * Created by Shay on 4/13/16.
 */
public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RecyclerView restaurantRecyclerView;
    private RestaurantAdapter adapter;
    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;

    public SearchFragment() {
        //Constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchText = (EditText) view.findViewById(R.id.searchText);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        restaurantRecyclerView = (RecyclerView) view.findViewById(R.id.RestaurantRecyclerView);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchResponse searchResponse = null;
                try {
                    searchResponse = ApiClient.getInstance().getSearchResponse(searchText.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (searchResponse != null) {
                    adapter = new RestaurantAdapter(searchResponse.businesses());
                    adapter.setOnItemSelected(new RestaurantAdapter.OnItemSelected() {
                        @Override
                        public void onSelected(Business item) {
                            if (onFragmentEvent != null) {
                                onFragmentEvent.onEvent(item);
                            }
                        }
                    });
                    restaurantRecyclerView.setLayoutManager(layoutManager);
                    restaurantRecyclerView.setAdapter(adapter);
                }
                // previous commented code at the bottom of this page
            }
        });
    return  view;
    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {super.onDetach();}

    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }

    public interface OnFragmentEvent {
        void onEvent(Business itemModel);
    }
}
/*
                ApiClient.getInstance().getRestaurantApiAdapter()
                        .getSearchResults()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<SearchResultsModel>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(SearchResultsModel searchResultsModel) {
                                adapter = new RestaurantAdapter(searchResultsModel.getSearchResults());
                                adapter.setOnItemSelected(new RestaurantAdapter.OnItemSelected() {
                                    @Override
                                    public void onSelected(RestaurantModel item) {
                                        if (onFragmentEvent != null) {
                                            onFragmentEvent.onEvent(item);
                                        }
                                    }
                                });

                                restaurantRecyclerView.setLayoutManager(layoutManager);
                                restaurantRecyclerView.setAdapter(adapter);
                            }
                        });
                        */

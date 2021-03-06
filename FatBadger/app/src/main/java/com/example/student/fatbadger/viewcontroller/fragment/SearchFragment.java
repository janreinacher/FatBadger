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
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.IOException;
import java.sql.Timestamp;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.viewHolder.RestaurantAdapter;
import com.example.student.fatbadger.service.api.ApiClient;

/**
 * Created by Shay on 4/13/16.
 */
public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RecyclerView restaurantRecyclerView;
    private CheckBox conv;
    private EditText maxDist;
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

    public Timestamp getTimestamp(){
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(date.getTime());
        return currentTimestamp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchText = (EditText) view.findViewById(R.id.searchText);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        conv = (CheckBox) view.findViewById(R.id.convenience);
        maxDist = (EditText) view.findViewById(R.id.maxDist);
        restaurantRecyclerView = (RecyclerView) view.findViewById(R.id.RestaurantRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dist = 0;
                if (maxDist.getText().toString() != "") {
                    dist = Integer.parseInt(maxDist.getText().toString());
                }
                SearchResultsModel results = ApiClient.getInstance().getRestaurantByName(
                        searchText.getText().toString(),
                        conv.isChecked(),
                        dist);


                if (results != null && results.getSearchResults().size() > 0) {
                    adapter = new RestaurantAdapter(results.getSearchResults());
                    adapter.setOnItemSelected(new RestaurantAdapter.OnItemSelected() {
                        @Override
                        public void onSelected(RestaurantModel item) {
                            boolean isFavorite = item.getFavorite();
                            boolean isBlocked = item.getBlocked();
                            if (onFragmentEvent != null) {
                                onFragmentEvent.onEvent(item);
                            }
                        }
                    });
                    restaurantRecyclerView.setLayoutManager(layoutManager);
                    restaurantRecyclerView.setAdapter(adapter);
                }
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
        void onEvent(RestaurantModel itemModel);
    }
}


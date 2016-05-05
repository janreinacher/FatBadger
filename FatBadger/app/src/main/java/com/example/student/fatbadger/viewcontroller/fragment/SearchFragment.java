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
import java.sql.Timestamp;
import java.util.Date;

import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.utility.RestaurantParser;
import com.example.student.fatbadger.viewHolder.RestaurantAdapter;
import com.example.student.fatbadger.service.api.ApiClient;
import com.example.student.fatbadger.viewcontroller.AppDefines;


import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
        restaurantRecyclerView = (RecyclerView) view.findViewById(R.id.RestaurantRecyclerView);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*
                    ApiClient.getInstance().getRestaurantApiAdapter()
                            .getSearchResults(
                                    searchText.getText().toString(),
                                    AppDefines.CONSUMER_KEY,
                                    AppDefines.CONSUMER_SECRET,
                                    AppDefines.TOKEN,
                                    AppDefines.TOKEN_SECRET,
                                    AppDefines.SIGNATURE_METHOD,
                                    AppDefines.SIGNATURE,
                                    getTimestamp(),
                                    AppDefines.NONCE

                                    ).subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<SearchResultsModel>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {
                                    int i = 0;
                                }

                                @Override
                                public void onNext(SearchResultsModel searchResultsModel) {
                                    if (searchResultsModel != null) {
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
                                }
                            });
                            */
                String json = "{\n" +
                        "    \"businesses\": [\n" +
                        "        {\n" +
                        "            \"categories\": [\n" +
                        "                [\n" +
                        "                    \"Local Flavor\",\n" +
                        "                    \"localflavor\"\n" +
                        "                ],\n" +
                        "                [\n" +
                        "                    \"Mass Media\",\n" +
                        "                    \"massmedia\"\n" +
                        "                ]\n" +
                        "            ],\n" +
                        "            \"display_phone\": \"+1-415-908-3801\",\n" +
                        "            \"id\": \"yelp-san-francisco\",\n" +
                        "            \"image_url\": \"http://s3-media3.fl.yelpcdn.com/bphoto/nQK-6_vZMt5n88zsAS94ew/ms.jpg\",\n" +
                        "            \"is_claimed\": true,\n" +
                        "            \"is_closed\": false,\n" +
                        "            \"location\": {\n" +
                        "                \"address\": [\n" +
                        "                    \"140 New Montgomery St\"\n" +
                        "                ],\n" +
                        "                \"city\": \"San Francisco\",\n" +
                        "                \"coordinate\": {\n" +
                        "                    \"latitude\": 37.7867703362929,\n" +
                        "                    \"longitude\": -122.399958372115\n" +
                        "                },\n" +
                        "                \"country_code\": \"US\",\n" +
                        "                \"cross_streets\": \"Natoma St & Minna St\",\n" +
                        "                \"display_address\": [\n" +
                        "                    \"140 New Montgomery St\",\n" +
                        "                    \"Financial District\",\n" +
                        "                    \"San Francisco, CA 94105\"\n" +
                        "                ],\n" +
                        "                \"geo_accuracy\": 9.5,\n" +
                        "                \"neighborhoods\": [\n" +
                        "                    \"Financial District\",\n" +
                        "                    \"SoMa\"\n" +
                        "                ],\n" +
                        "                \"postal_code\": \"94105\",\n" +
                        "                \"state_code\": \"CA\"\n" +
                        "            },\n" +
                        "            \"mobile_url\": \"http://m.yelp.com/biz/yelp-san-francisco\",\n" +
                        "            \"name\": \"Yelp\",\n" +
                        "            \"phone\": \"4159083801\",\n" +
                        "            \"rating\": 2.5,\n" +
                        "            \"rating_img_url\": \"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/c7fb9aff59f9/ico/stars/v1/stars_2_half.png\",\n" +
                        "            \"rating_img_url_large\": \"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/d63e3add9901/ico/stars/v1/stars_large_2_half.png\",\n" +
                        "            \"rating_img_url_small\": \"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/8e8633e5f8f0/ico/stars/v1/stars_small_2_half.png\",\n" +
                        "            \"review_count\": 7140,\n" +
                        "            \"snippet_image_url\": \"http://s3-media4.fl.yelpcdn.com/photo/YcjPScwVxF05kj6zt10Fxw/ms.jpg\",\n" +
                        "            \"snippet_text\": \"What would I do without Yelp?\\n\\nI wouldn't be HALF the foodie I've become it weren't for this business.    \\n\\nYelp makes it virtually effortless to discover new...\",\n" +
                        "            \"url\": \"http://www.yelp.com/biz/yelp-san-francisco\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"total\": 2316\n" +
                        "}";

                RestaurantParser parser = new RestaurantParser();
                SearchResultsModel searchResultsModel = parser.parseRestaurantFromJson(json);
                if (searchResultsModel != null) {
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


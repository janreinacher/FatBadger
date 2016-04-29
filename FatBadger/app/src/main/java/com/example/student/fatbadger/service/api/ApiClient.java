
package com.example.student.fatbadger.service.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.student.fatbadger.viewcontroller.AppDefines;
import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.SearchResponse;
import com.example.student.fatbadger.service.adapter.RestaurantApiAdapter;

//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by student on 4/13/16.
 */
public class ApiClient {

    private static ApiClient instance;
    private Map<String, String> callparams;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    private YelpAPIFactory apiFactory;
    private YelpAPI yelpAPI;

    public YelpAPI CreateAPI() {
        callparams = new HashMap<>();
        {
            // general params
            callparams.put("term", "food");
            callparams.put("limit", "20");
        }

        return yelpAPI = new YelpAPIFactory(AppDefines.CONSUMER_KEY, AppDefines.CONSUMER_SECRET, AppDefines.TOKEN, AppDefines.TOKEN_SECRET).createAPI();
    }

    public SearchResponse getSearchResponse(String searchString) throws IOException {

        new AsyncTask<String, String, Response<SearchResponse>>() {

            private Response<SearchResponse> resp;


            @Override
            protected Response<SearchResponse> doInBackground(String... params) {

                YelpAPI api = CreateAPI();
                Call<SearchResponse> call = api.search(params[0], callparams);
                try {
                    resp = call.execute();
                } catch (IOException e) {
                    Log.d("OH SHIT", e.getMessage());
                }

                return resp;
            }

            @Override
            protected void onPostExecute(Response<SearchResponse> searchResponseResponse) {
                super.onPostExecute(searchResponseResponse);

            }
        }.execute(searchString);

        return null;
    }

    public void addParam(String key, String value) {
        callparams.put(key,value);
    }
}
package com.example.student.fatbadger.service.api;

import com.example.student.fatbadger.service.api.ApiClient;
import com.example.student.fatbadger.viewcontroller.AppDefines;
import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.SearchResponse;
import org.apache.commons.io.IOUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;

/**
 * Created by Jackson on 4/14/16.
 */
public class HttpRequestManager {

    public String getResults(String searchString) throws IOException {

        ApiClient.getInstance().CreateAPI();
        Map<String, String> params = new HashMap<>();
        {
            // general params
            params.put("term", "food");
            params.put("limit", "20");
        }
        Call<SearchResponse> call = ApiClient.getInstance().call(params, searchString);
        retrofit.Response<SearchResponse> response = call.execute();
        String url = response.body().toString();
        return url;
    }
}
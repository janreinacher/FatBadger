
package com.example.student.fatbadger.service.api;

import android.util.Log;

import com.example.student.fatbadger.model.RestaurantModel;
import com.example.student.fatbadger.model.SearchResultsModel;
import com.example.student.fatbadger.viewcontroller.AppDefines;
//import com.yelp.clientlib.connection.YelpAPI;
//import com.yelp.clientlib.connection.YelpAPIFactory;
//import com.yelp.clientlib.entities.SearchResponse;
import com.example.student.fatbadger.service.adapter.RestaurantApiAdapter;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;
//import retrofit.Call;

/**
 * Created by student on 4/13/16.
 */
public class ApiClient {

    private static ApiClient instance;
    private Map<String, String> params;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    //private YelpAPIFactory apiFactory;
    //private YelpAPI yelpAPI;


    public SearchResultsModel getRestaurantByName(String name) {
        ArrayList<RestaurantModel> searchResults = new ArrayList<>();
        SearchResultsModel model = new SearchResultsModel();

        RestaurantModel r1 = new RestaurantModel();
        r1.setName("McDonalds");
        r1.setImg_url("https://lh3.ggpht.com/yemL6Ac58n_bwAue3QGnSthwVmhGEY-1Yfvosaw4HHbz9hhc5fcJ_Gv0eHisqxdiWg=w170");
        r1.setDisplayPhone("1(800)555-1234");
        r1.setHours("6 AM - 12 PM");
        r1.setDisplayAddress("1234 Yellow Brick Road\n Austin, TX 50505");
        searchResults.add(r1);

        RestaurantModel r2 = new RestaurantModel();
        r2.setName("Taco Bell");
        r2.setImg_url("http://hackthemenu.com/wp-content/uploads/2013/08/taco-bell-logo.jpg");
        r2.setDisplayPhone("1(800)555-1234");
        r2.setHours("6 AM - 2 AM");
        r2.setDisplayAddress("1234 east cotati\n Rohnert Park, CA 94928");
        searchResults.add(r2);

        RestaurantModel res1 = new RestaurantModel();
        res1.setName("Taco Hut");
        res1.setDisplayPhone("894-421-9920");
        res1.setHours("10 AM - 10 PM");
        res1.setDisplayAddress("1 E Cotati Ave, Rohnert Park");
        res1.setImg_url("https://upload.wikimedia.org/wikipedia/commons/b/b8/Taco_Bell_Night.JPG");
        searchResults.add(res1);

        RestaurantModel res2 = new RestaurantModel();
        res2.setName("Cancun Exotic Eats");
        res2.setDisplayPhone("888-922-9142");
        res2.setHours("1 PM - 10 PM");
        res2.setDisplayAddress("77 Redwood Dr, Rohnert Park");
        res2.setImg_url("https://media-cdn.tripadvisor.com/media/photo-s/08/20/f9/e1/cancun-mexican-restaurant.jpg");
        searchResults.add(res2);

        RestaurantModel res3 = new RestaurantModel();
        res3.setName("Pizza Hut");
        res3.setDisplayPhone("911-931-9222");
        res3.setHours("10 AM - 11 PM");
        res3.setDisplayAddress("22 Mission Ave, San Francisco");
        res3.setImg_url("https://media.glassdoor.com/lst/07/92/04/99/this-is-a-pizza-hut-building.jpg");
        searchResults.add(res3);

        RestaurantModel res4 = new RestaurantModel();
        res4.setName("French Laundry");
        res4.setDisplayPhone("824-999-9678");
        res4.setHours("11 AM - 4 PM");
        res4.setDisplayAddress("111 Market St, San Francisco");
        res4.setImg_url("http://www.nandos.com/sites/all/themes/nandos/images/restaurants/restaurant-carousel-1.jpg");
        searchResults.add(res4);

        RestaurantModel res5 = new RestaurantModel();
        res5.setName("Taco Jose");
        res5.setDisplayPhone("111-111-1111");
        res5.setHours("10 AM - 12 PM");
        res5.setDisplayAddress("12 George Ave, Petaluma");
        res5.setImg_url("https://upload.wikimedia.org/wikipedia/commons/1/1e/Tom's_Restaurant,_NYC.jpg");
        searchResults.add(res5);

        RestaurantModel res6 = new RestaurantModel();
        res6.setName("Ye Olde Pub");
        res6.setDisplayPhone("921-111-9211");
        res6.setHours("4 PM - 4 AM");
        res6.setDisplayAddress("12 Vinyard Ave, Rohnert Park");
        res6.setImg_url("http://images.teamsugar.com/files/upl1/1/17470/34_2008/art_divebar_01.preview.jpg");
        searchResults.add(res6);

        RestaurantModel res7 = new RestaurantModel();
        res7.setName("Hipster Fuel");
        res7.setDisplayPhone("707-121-3111");
        res7.setHours("6 AM - 8 PM");
        res7.setDisplayAddress("455 Orchard Ave, Rohnert Park");
        res7.setImg_url("http://www.deliciousorchardsnjonline.com/blog/wp-content/uploads/juice-smoothie.jpg");
        searchResults.add(res7);

        RestaurantModel res8 = new RestaurantModel();
        res8.setName("The Ice Cream Shop");
        res8.setDisplayPhone("925-555-3111");
        res8.setHours("12 PM - 10 PM");
        res8.setDisplayAddress("42 B St, Cotati");
        res8.setImg_url("https://makanarts.files.wordpress.com/2013/12/dscf0839.jpg\n");
        searchResults.add(res8);

        RestaurantModel res9 = new RestaurantModel();
        res9.setName("Tea shop");
        res9.setDisplayPhone("921-121-2211");
        res9.setHours("10 AM - 6PM");
        res9.setDisplayAddress("315 M St, Rohnert Park");
        res9.setImg_url("http://www.thediningroom.ie/wp-content/uploads/2013/05/pacinos_restaurant_front.jpg");
        searchResults.add(res9);

        RestaurantModel res10 = new RestaurantModel();
        res10.setName("Andreas Mediterranian Kitchen");
        res10.setDisplayPhone("961-121-1111");
        res10.setHours("9 AM - 12 PM");
        res10.setDisplayAddress("22 Gough St, San Francisco");
        res10.setImg_url("http://www.andreas-restaurant.com/images/pics/andreas_restaurant_front_entrance.jpg");
        searchResults.add(res10);

        model.setSearchResults(new ArrayList<RestaurantModel>());

        for (RestaurantModel r : searchResults) {
            if (r.getName().toLowerCase().contains(name.toLowerCase())) {
                model.getSearchResults().add(r);
            }
            //else if(r.get)
        }

        return model;
    }


}
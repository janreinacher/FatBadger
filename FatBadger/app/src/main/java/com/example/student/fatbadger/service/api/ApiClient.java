
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.sql.Timestamp;

import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;
//import retrofit.Call;

/**
 * Created by student on 4/13/16.
 */
public class ApiClient {

    private static ApiClient instance;
    private Map<String, String> params;
    private SearchResultsModel results;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    //private YelpAPIFactory apiFactory;
    //private YelpAPI yelpAPI;

    public String getTimestamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        String currentTimeStamp = dateFormat.format(new Date()); // Find todays date

        return currentTimeStamp;
    }

    public ArrayList<RestaurantModel> generateData() {
        ArrayList<RestaurantModel> searchResults = new ArrayList<>();

        RestaurantModel r1 = new RestaurantModel();
        r1.setName("McDonalds");
        r1.setImg_url("https://lh3.ggpht.com/yemL6Ac58n_bwAue3QGnSthwVmhGEY-1Yfvosaw4HHbz9hhc5fcJ_Gv0eHisqxdiWg=w170");
        r1.setDisplayPhone("1(800)555-1234");
        r1.setOpen("06");
        r1.setClose("24");
        r1.setHours("6 AM - 12 AM");
        r1.setDisplayAddress("1234 Yellow Brick Road\n Austin, TX 50505");
        r1.setDistance(2000);
        searchResults.add(r1);

        RestaurantModel r2 = new RestaurantModel();
        r2.setName("Taco Bell");
        r2.setImg_url("http://hackthemenu.com/wp-content/uploads/2013/08/taco-bell-logo.jpg");
        r2.setDisplayPhone("1(800)555-1234");
        r2.setOpen("06");
        r2.setClose("24");
        r2.setHours("6 AM - 12 AM");
        r2.setDisplayAddress("1234 east cotati\n Rohnert Park, CA 94928");
        r2.setDistance(1);
        r2.setFavorite(true);
        searchResults.add(r2);

        RestaurantModel res1 = new RestaurantModel();
        res1.setName("Taco Hut");
        res1.setDisplayPhone("894-421-9920");
        res1.setOpen("10");
        res1.setClose("22");
        res1.setHours("10 AM - 10 PM");
        res1.setDisplayAddress("1 E Cotati Ave, Rohnert Park");
        res1.setImg_url("https://upload.wikimedia.org/wikipedia/commons/b/b8/Taco_Bell_Night.JPG");
        res1.setDistance(3);
        res1.setBlocked(true);
        searchResults.add(res1);

        RestaurantModel res2 = new RestaurantModel();
        res2.setName("Cancun Exotic Eats");
        res2.setDisplayPhone("888-922-9142");
        res2.setOpen("13");
        res2.setClose("22");
        res2.setHours("1 PM - 10 PM");
        res2.setDisplayAddress("77 Redwood Dr, Rohnert Park");
        res2.setImg_url("https://media-cdn.tripadvisor.com/media/photo-s/08/20/f9/e1/cancun-mexican-restaurant.jpg");
        res2.setDistance(4);
        searchResults.add(res2);

        RestaurantModel res3 = new RestaurantModel();
        res3.setName("Pizza Hut");
        res3.setDisplayPhone("911-931-9222");
        res3.setOpen("10");
        res3.setClose("23");
        res3.setHours("10 AM - 11 PM");
        res3.setDisplayAddress("22 Mission Ave, San Francisco");
        res3.setDistance(36);
        res3.setImg_url("https://media.glassdoor.com/lst/07/92/04/99/this-is-a-pizza-hut-building.jpg");
        searchResults.add(res3);

        RestaurantModel res4 = new RestaurantModel();
        res4.setName("French Laundry");
        res4.setDisplayPhone("824-999-9678");
        res4.setOpen("11");
        res4.setClose("15");
        res4.setHours("11 AM - 4 PM");
        res4.setDisplayAddress("111 Market St, San Francisco");
        res4.setDistance(33);
        res4.setImg_url("http://www.nandos.com/sites/all/themes/nandos/images/restaurants/restaurant-carousel-1.jpg");
        searchResults.add(res4);

        RestaurantModel res5 = new RestaurantModel();
        res5.setName("Taco Jose");
        res5.setDisplayPhone("111-111-1111");
        res5.setOpen("10");
        res5.setClose("12");
        res5.setHours("10 AM - 12 PM");
        res5.setDistance(15);
        res5.setDisplayAddress("12 George Ave, Petaluma");
        res5.setImg_url("https://upload.wikimedia.org/wikipedia/commons/1/1e/Tom's_Restaurant,_NYC.jpg");
        searchResults.add(res5);

        RestaurantModel res6 = new RestaurantModel();
        res6.setName("Ye Olde Pub");
        res6.setDisplayPhone("921-111-9211");
        res6.setOpen("18");
        res6.setClose("04");
        res6.setHours("6 PM - 4 AM");
        res6.setDisplayAddress("12 Vinyard Ave, Rohnert Park");
        res6.setDistance(5);
        res6.setImg_url("http://images.teamsugar.com/files/upl1/1/17470/34_2008/art_divebar_01.preview.jpg");
        res6.setFavorite(true);
        searchResults.add(res6);

        RestaurantModel res7 = new RestaurantModel();
        res7.setName("Hipster Fuel");
        res7.setDisplayPhone("707-121-3111");
        res7.setOpen("06");
        res7.setClose("20");
        res7.setHours("6 AM - 8 PM");
        res7.setDisplayAddress("455 Orchard Ave, Rohnert Park");
        res7.setDistance(7);
        res7.setImg_url("http://www.deliciousorchardsnjonline.com/blog/wp-content/uploads/juice-smoothie.jpg");
        searchResults.add(res7);

        RestaurantModel res8 = new RestaurantModel();
        res8.setName("The Ice Cream Shop");
        res8.setDisplayPhone("925-555-3111");
        res8.setOpen("12");
        res8.setClose("22");
        res8.setHours("12 PM - 10 PM");
        res8.setDisplayAddress("42 B St, Cotati");
        res8.setDistance(11);
        res8.setImg_url("https://makanarts.files.wordpress.com/2013/12/dscf0839.jpg\n");
        searchResults.add(res8);

        RestaurantModel res9 = new RestaurantModel();
        res9.setName("Tea shop");
        res9.setDisplayPhone("921-121-2211");
        res9.setOpen("10");
        res9.setClose("18");
        res9.setHours("10 AM - 6PM");
        res9.setDisplayAddress("315 M St, Rohnert Park");
        res9.setDistance(6);
        res9.setImg_url("http://www.thediningroom.ie/wp-content/uploads/2013/05/pacinos_restaurant_front.jpg");
        res9.setBlocked(true);
        searchResults.add(res9);

        RestaurantModel res10 = new RestaurantModel();
        res10.setName("Andreas Mediterranian Kitchen");
        res10.setDisplayPhone("961-121-1111");
        res10.setOpen("09");
        res10.setClose("12");
        res10.setHours("9 AM - 12 PM");
        res10.setDisplayAddress("22 Gough St, San Francisco");
        res10.setDistance(42);
        res10.setImg_url("http://www.andreas-restaurant.com/images/pics/andreas_restaurant_front_entrance.jpg");
        searchResults.add(res10);

        RestaurantModel res11 = new RestaurantModel();
        res11.setName("Carlos Country Kitchen");
        res11.setDisplayPhone("707-954-3234");
        res11.setOpen("06");
        res11.setClose("16");
        res11.setHours("6 AM - 4 PM");
        res11.setDisplayAddress("153 College Avenue, Santa Rosa");
        res11.setDistance(24);
        res11.setImg_url("https://b.zmtcdn.com/data/pictures/2/16855132/80f4f3d4e824d3f2e4292ef7af026185_featured_v2.jpg");
        searchResults.add(res11);

        RestaurantModel res12 = new RestaurantModel();
        res12.setName("Biancini's Sandwiches");
        res12.setDisplayPhone("707-932-4204");
        res12.setOpen("10");
        res12.setClose("22");
        res12.setHours("10 AM - 10 PM");
        res12.setDisplayAddress(" 42 Mendocino Avenue, Santa Rosa");
        res12.setDistance(22);
        res12.setImg_url("https://b.zmtcdn.com/data/pictures/9/18116349/93bfe4a6a84cdf3e9e48d5ae98e5bc95.jpg");
        searchResults.add(res12);

        RestaurantModel res13 = new RestaurantModel();
        res13.setName("Janny's");
        res13.setDisplayPhone("914-300-0077");
        res13.setOpen("11");
        res13.setClose("20");
        res13.setHours("11 AM - 8 PM");
        res13.setDisplayAddress("321 Petaluma Hill Road, Pengrove");
        res13.setDistance(17);
        res13.setImg_url("http://jessposhepny.com/wp-content/uploads/2015/07/image1-e1437847179508-1024x1024.jpg");
        res13.setBlocked(true);
        searchResults.add(res13);

        RestaurantModel res14 = new RestaurantModel();
        res14.setName("Five Guys Burgers");
        res14.setDisplayPhone("282-330-5621");
        res14.setOpen("10");
        res14.setClose("22");
        res14.setHours("10 AM - 10PM");
        res14.setDisplayAddress("92 Mendocino Avenue, Santa Rosa");
        res14.setDistance(22);
        res14.setImg_url("http://www.fiveguys.com/Content/Images/first-fiveguysshop.jpg");
        searchResults.add(res14);

        RestaurantModel res15 = new RestaurantModel();
        res15.setName("Day Drinkers");
        res15.setDisplayPhone("1(800)tacosNbeer");
        res15.setOpen("04");
        res15.setClose("21");
        res15.setHours("4 AM - 9PM");
        res15.setDisplayAddress("64 Mendocino Avenue, Santa Rosa");
        res15.setDistance(23);
        res15.setImg_url("http://lifestyleetc.com/wp-content/uploads/2014/05/daydrinking.jpg");
        searchResults.add(res15);

       return searchResults;
    }

    public SearchResultsModel getRestaurantByName(String name) {
        ArrayList<RestaurantModel> searchResults = generateData();
        SearchResultsModel model = new SearchResultsModel();

        model.setSearchResults(new ArrayList<RestaurantModel>());
        for (RestaurantModel r : searchResults) {
            // name matches search
            if (r.getName().toLowerCase().contains(name.toLowerCase())) {
                model.getSearchResults().add(r);
            }
            // address matches search
            else if(r.getDisplayAddress().toLowerCase().contains(name.toLowerCase())){
                model.getSearchResults().add(r);
            }

            String time = getTimestamp();
            // Checks if restaurant is open
            if (true) { // want shays toggle for this
                if (Integer.parseInt(r.getOpen()) < Integer.parseInt(r.getClose())) {
                    if (!(Integer.parseInt(r.getOpen()) <= Integer.parseInt(time) &&
                            Integer.parseInt(time) <= Integer.parseInt(r.getClose()))) {
                        //model.getSearchResults().remove(r);
                    }
                } else {
                    if (!(Integer.parseInt(r.getOpen()) <= Integer.parseInt(time) ||
                            Integer.parseInt(time) <= Integer.parseInt(r.getClose()))) {
                        //model.getSearchResults().remove(r);
                    }
                }
            }

            // checks if restaurant is within x miles
            Integer maxDist = 10;   // waiting for Edit text object that can hold an int value
            if (r.getDistance() > maxDist){
                //model.getSearchResults().remove(r);
            }
        }
        return model;
    }

    public SearchResultsModel getFavoriteRestaurants() {
        ArrayList<RestaurantModel> searchResults = generateData();
        SearchResultsModel model = new SearchResultsModel();
        for (RestaurantModel r: searchResults) {
            // only display favorites
            if(r.getFavorite())
                model.getSearchResults().add(r);
        }
        return model;
    }

    public SearchResultsModel getBlockedRestaurants() {
        ArrayList<RestaurantModel> searchResults = generateData();
        SearchResultsModel model = new SearchResultsModel();
        for (RestaurantModel r: searchResults) {
            // only display blocked
            if(r.getBlocked())
                model.getSearchResults().add(r);
        }
        return model;
    }


}
package com.example.student.fatbadger.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by student on 4/13/16.
 */
public class SearchResultsModel {
    @SerializedName("businesses")
    ArrayList<RestaurantModel> searchResults;

    public ArrayList<RestaurantModel> getSearchResults() {
        return searchResults;
    }

    public void generateData() {

        searchResults = new ArrayList<RestaurantModel>();

        RestaurantModel r1 = new RestaurantModel();
        r1.setName("McDonalds");
        r1.setImg_url("https://lh3.ggpht.com/yemL6Ac58n_bwAue3QGnSthwVmhGEY-1Yfvosaw4HHbz9hhc5fcJ_Gv0eHisqxdiWg=w170");
        r1.setDisplayPhone("1(800)555-1234");
        r1.setDisplayAddress("1234 yellow brick road\n austin, tx 50505");
        searchResults.add(r1);

        RestaurantModel r2 = new RestaurantModel();
        r2.setName("TacoBell");
        r2.setImg_url("http://hackthemenu.com/wp-content/uploads/2013/08/taco-bell-logo.jpg");
        r2.setDisplayPhone("1(800)555-1234");
        r2.setDisplayAddress("1234 east cotati\n rohnert park, ca 94928");
        searchResults.add(r2);

        RestaurantModel res1 = new RestaurantModel();
        res1.setName("Taco Hut");
        res1.setDisplayPhone("999-999-9999");
        res1.setDisplayAddress("1 E Cotati ave, Rohnert Park");
        res1.setImg_url("https://upload.wikimedia.org/wikipedia/commons/b/b8/Taco_Bell_Night.JPG");
        searchResults.add(res1);

        RestaurantModel res2 = new RestaurantModel();
        res2.setName("Indian food place");
        res2.setDisplayPhone("888-922-9142");
        res2.setDisplayAddress("77 Redwood dr, Rohnert Park");
        res2.setImg_url("https://media-cdn.tripadvisor.com/media/photo-s/08/20/f9/e1/cancun-mexican-restaurant.jpg");
        searchResults.add(res2);

        RestaurantModel res3 = new RestaurantModel();
        res3.setName("Food seller");
        res3.setDisplayPhone("911-931-9222");
        res3.setDisplayAddress("420 Market st, San Francisco");
        res3.setImg_url("https://media.glassdoor.com/lst/07/92/04/99/this-is-a-pizza-hut-building.jpg");
        searchResults.add(res3);

        RestaurantModel res4 = new RestaurantModel();
        res4.setName("A diner");
        res4.setDisplayPhone("824-999-9678");
        res4.setDisplayAddress("111 Market st, San Francisco");
        res4.setImg_url("http://www.nandos.com/sites/all/themes/nandos/images/restaurants/restaurant-carousel-1.jpg");
        searchResults.add(res4);

        RestaurantModel res5 = new RestaurantModel();
        res5.setName("Taco Jose");
        res5.setDisplayPhone("111-111-1111");
        res5.setDisplayAddress("12 George ave, Petaluma");
        res5.setImg_url("https://upload.wikimedia.org/wikipedia/commons/1/1e/Tom's_Restaurant,_NYC.jpg");
        searchResults.add(res5);

        RestaurantModel res6 = new RestaurantModel();
        res6.setName("Ice cream shop");
        res6.setDisplayPhone("921-111-9211");
        res6.setDisplayAddress("12 vinyard ave, Rohnert Park");
        res6.setImg_url("http://images.teamsugar.com/files/upl1/1/17470/34_2008/art_divebar_01.preview.jpg");
        searchResults.add(res6);

        RestaurantModel res7 = new RestaurantModel();
        res7.setName("Applesause");
        res7.setDisplayPhone("921-121-3111");
        res7.setDisplayAddress("455 orchard ave, Rohnert Park");
        res7.setImg_url("http://www.deliciousorchardsnjonline.com/blog/wp-content/uploads/juice-smoothie.jpg");
        searchResults.add(res7);

        RestaurantModel res8 = new RestaurantModel();
        res8.setName("Tuesday afternoon");
        res8.setDisplayPhone("925-555-3111");
        res8.setDisplayAddress("42 b st, Cotati");
        res8.setImg_url("https://makanarts.files.wordpress.com/2013/12/dscf0839.jpg\n");
        searchResults.add(res8);

        RestaurantModel res9 = new RestaurantModel();
        res9.setName("Tea shop");
        res9.setDisplayPhone("921-121-2211");
        res9.setDisplayAddress("315 m st, Rohnert Park");
        res9.setImg_url("http://www.thediningroom.ie/wp-content/uploads/2013/05/pacinos_restaurant_front.jpg");
        searchResults.add(res9);

        RestaurantModel res10 = new RestaurantModel();
        res10.setName("Sushi food");
        res10.setDisplayPhone("961-121-1111");
        res10.setDisplayAddress("22 street st, San Francisco");
        res10.setImg_url("http://www.andreas-restaurant.com/images/pics/andreas_restaurant_front_entrance.jpg");
        searchResults.add(res10);
    }
}

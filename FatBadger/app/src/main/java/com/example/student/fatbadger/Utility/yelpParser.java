package com.example.student.fatbadger.Utility;

import com.google.gson.Gson;
import com.example.student.fatbadger.model.SearchResultsModel;

/**
 * Created by student on 4/13/16.
 */

public class yelpParser {
    private String inputString = "{\n" +
            "    \"businesses\": [\n" +
            "        {\n" +
            "            \"categories\": [\n" +
            "                [\n" +
            "                    \"Fast Food\",\n" +
            "                    \"fastfood\"\n" +
            "                ],\n" +
            "                [\n" +
            "                    \"Taco Bell\",\n" +
            "                    \"tacobell\"\n" +
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
            "            \"rating_img_url\":   \"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/c7fb9aff59f9/ico/stars/v1/stars_2_half.png\",\n" +
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
    public static final SearchResultsModel parseRecipeFromJson(final String inputString) {
        SearchResultsModel SearchResultsModel;
        Gson gson = new Gson();
        SearchResultsModel = gson.fromJson(inputString, com.example.student.fatbadger.model.SearchResultsModel.class);

        return SearchResultsModel;
    }
}

package com.example.student.fatbadger.utility;

import com.example.student.fatbadger.viewcontroller.AppDefines;
/**
 * Created by Shay on 4/23/16.
 */
public class UrlFormatUtility {
    private static final String Restaurant_Route = "/search?";

    public static String formatRestaurantSearchString(String searchString){
        String urlString = AppDefines.BASE_API_URL + Restaurant_Route +
                "&term_key=" + AppDefines.CONSUMER_KEY + "&term_secret=" +
                AppDefines.CONSUMER_SECRET + "&token_key=" + AppDefines.TOKEN
                + "&token_secret=" + AppDefines.TOKEN_SECRET +
                "&q=" + searchString;

        return urlString;
    }
}

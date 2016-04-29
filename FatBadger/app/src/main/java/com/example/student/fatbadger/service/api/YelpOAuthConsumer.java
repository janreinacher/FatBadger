package com.example.student.fatbadger.service.api;

import java.util.UUID;

import oauth.signpost.http.HttpRequest;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

/**
 * Created by student on 4/28/16.
 */
public class YelpOAuthConsumer extends OkHttpOAuthConsumer {
    public YelpOAuthConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    @Override
    protected HttpRequest wrap(Object request) {
        return super.wrap(request);
    }

    @Override
    protected String generateNonce() {
        return UUID.randomUUID().toString();
    }
}

package com.example.student.fatbadger.model;

import java.io.Serializable;

/**
 * Created by student on 4/13/16.
 */
public class
        RestaurantModel implements Serializable {
    private String name;
    private String display_phone;
    private Double rating;
    private String address;
    private String city;
    private String state;
    private Boolean is_closed;
    private String img_url;
    private String details;

    public String getDetails() {return details;}

    public void setDetails(String details) {this.details = details;}

    public String getImg_url() { return img_url; }

    public void setImg_url(String img_url) { this.img_url = img_url; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public Boolean getIs_closed() { return is_closed; }

    public void setIs_closed(Boolean is_closed) { this.is_closed = is_closed; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDisplay_phone() { return display_phone; }

    public void setDisplay_phone(String display_phone) { this.display_phone = display_phone; }

    public Double getRating() { return rating; }

    public void setRating(Double rating) { this.rating = rating; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

}

package com.example.student.fatbadger.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by student on 4/13/16.
 */
public class
        RestaurantModel implements Serializable {

    private String id;
    private String name;
    private String display_phone;
    private ArrayList<String> display_address;
    private Double rating;
    private Boolean is_closed;
    private String image_url;
    private String details;

    public String getId() {return id;}

    public void setId( String id ) { this.id = id; }

    public String getDetails() {return details;}

    public void setDetails(String details) {this.details = details;}

    public String getImg_url() { return image_url; }

    public void setImg_url(String img_url) { this.image_url = img_url; }

    public Boolean getIs_closed() { return is_closed; }

    public void setIs_closed(Boolean is_closed) { this.is_closed = is_closed; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDisplayPhone() { return display_phone; }

    public void setDisplayPhone(String display_phone) { this.display_phone = display_phone; }

    public Double getRating() { return rating; }

    public void setRating(Double rating) { this.rating = rating; }

    public ArrayList<String> getDisplayAddress() { return display_address; }

    public void setDisplayAddress(ArrayList<String> display_address) { this.display_address = display_address; }

}

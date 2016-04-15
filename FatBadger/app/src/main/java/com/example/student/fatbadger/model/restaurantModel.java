package com.example.student.fatbadger.model;

/**
 * Created by student on 4/13/16.
 */
public class RestaurantModel {
    private String name;
    private String display_phone;
    private Double rating;
    private String address;
    private String city;
    private String state;
    private Boolean is_closed;

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

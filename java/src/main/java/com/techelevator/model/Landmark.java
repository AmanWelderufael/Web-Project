package com.techelevator.model;

public class Landmark {

    private int landmark_id;
    private int address_id;
    private String landmark_name;
    private String landmark_description;
    private int street_number;
    private String street_name;
    private String city_name;
    private String state_name;
    private int zip_code;
    private float latitude;
    private float longitude;
//*********************************************
    private int itinerary_id;
    private int user_id;
    private String itinerary_name;
    private int starting_landmark_id;
//****************************************************

    public Landmark(){};

    public int getLandmark_id() {
        return landmark_id;
    }

    public void setLandmark_id(int landmark_id) {
        this.landmark_id = landmark_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getLandmark_name() {
        return landmark_name;
    }

    public void setLandmark_name(String landmark_name) {
        this.landmark_name = landmark_name;
    }

    public String getLandmark_description() {
        return landmark_description;
    }

    public void setLandmark_description(String landmark_description) {
        this.landmark_description = landmark_description;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    //******************************
    // might need to delete this

    public int getItinerary_id() {
        return itinerary_id;
    }

    public void setItinerary_id(int itinerary_id) {
        this.itinerary_id = itinerary_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getItinerary_name() {
        return itinerary_name;
    }

    public void setItinerary_name(String itinerary_name) {
        this.itinerary_name = itinerary_name;
    }

    public int getStarting_landmark_id() {
        return starting_landmark_id;
    }

    public void setStarting_landmark_id(int starting_landmark_id) {
        this.starting_landmark_id = starting_landmark_id;
    }


}

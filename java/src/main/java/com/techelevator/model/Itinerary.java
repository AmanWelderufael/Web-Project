package com.techelevator.model;

public class Itinerary {
    private int itinerary_id;
    private int user_id;
    private String itinerary_name;
    private int starting_landmark_id;

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

package com.techelevator.dao;

public interface ItineraryDAO {

    public void createItinerary (int landmarkId, int userId);
    public void deleteItinerary(int landmarkId); //What else can we use to delete Itinerary?
}

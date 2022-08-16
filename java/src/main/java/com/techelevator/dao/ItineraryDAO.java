package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.util.List;

public interface ItineraryDAO {
    public int createItinerary(int userId, Itinerary itinerary);
    public void deleteItinerary(int landmarkId); //What else can we use to delete Itinerary?
    public void addToItinerary(int itineraryId, int landmarkId);
    public List<Itinerary> getItinerariesForUser(int userId);
    public List<Landmark> getLandmarksOnItinerary(int itineraryId);
    public void removeLandmark(int itineraryId, int landmarkId);


}

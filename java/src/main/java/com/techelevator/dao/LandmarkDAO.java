package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDAO {


    List<Landmark> retrieveAllLandmark();

//    List<Landmark> searchForLandmark(String landmark_name);

}

package com.techelevator.controller;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class ItineraryController {
    @Autowired
    UserDao userDao;

    @Autowired
    ItineraryDAO itineraryDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/Itinerary", method= RequestMethod.POST)
    public void createItinerary (@Valid @RequestBody Itinerary itinerary, Principal principal){
        int userID = userDao.findIdByUsername(principal.getName());
        int itinerary_id = itineraryDAO.createItinerary(userID, itinerary);
        itineraryDAO.addToItinerary(itinerary_id, itinerary.getStarting_landmark_id());
    }

    @RequestMapping(path="/Itinerary/{id}", method= RequestMethod.POST )
    public void addToItinerary(@Valid @RequestBody Landmark landmark,@PathVariable int id){
        itineraryDAO.addToItinerary(id, landmark.getLandmark_id());
    }

    @RequestMapping(path="/Itinerary/{id}", method= RequestMethod.DELETE)
    public void deleteItinerary(@Valid @PathVariable int id){
        itineraryDAO.deleteItinerary(id);
    }

    @RequestMapping(path="/Itinerary", method = RequestMethod.GET)
    public List<Itinerary> getItinerariesForUser(Principal principal){

        int userId = userDao.findIdByUsername(principal.getName());
        return itineraryDAO.getItinerariesForUser(userId);


    }

    @RequestMapping(path="/Itinerary/landmark/{id}", method = RequestMethod.GET)
    public List<Landmark> getLandmarksOnItinerary(@Valid @PathVariable int id){
        return itineraryDAO.getLandmarksOnItinerary(id);

    }

    @RequestMapping(path="/Itinerary{itineraryId}/landmark{landmarkId}", method = RequestMethod.DELETE)
    public void removeLandmarkOnItinerary(@Valid @PathVariable int itineraryId, @PathVariable int landmarkId){
        itineraryDAO.removeLandmark(itineraryId, landmarkId);
    }

   }

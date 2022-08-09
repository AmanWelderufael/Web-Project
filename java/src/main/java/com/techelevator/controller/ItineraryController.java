package com.techelevator.controller;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ItineraryController {
    @Autowired
    UserDao userDao;

    @Autowired
    ItineraryDAO itineraryDAO;


    @RequestMapping(path="/addItinerary/{id}", method= RequestMethod.POST)
    public void createItinerary (){
        //Implement here
    };

    @RequestMapping(path="/deleteItinerary/{landmarkId}", method= RequestMethod.DELETE)
    public void deleteItinerary(){
        //Implement here
    }
}

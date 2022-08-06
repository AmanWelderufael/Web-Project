package com.techelevator.controller;


import com.techelevator.dao.JDBCLandmarkDAO;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Landmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LandmarkController {
    @Autowired
    private JDBCLandmarkDAO landmarkDAO;
    @Autowired
    private JdbcUserDao userDao;

    @RequestMapping(value = "/retrieveLandMark", method = RequestMethod.GET)
    public List<Landmark> retrieveAllLandmark(){
        return landmarkDAO.retrieveAllLandmark();
    }
//    @RequestMapping(value = "/searchLandMark/{landmark_name}", method = RequestMethod.GET)
//    public List<Landmark> searchForLandmark(String landmark_name){
//        return landmarkDAO.searchForLandmark(landmark_name);
//    }
}

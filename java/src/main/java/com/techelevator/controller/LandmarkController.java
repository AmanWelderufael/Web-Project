package com.techelevator.controller;


import com.techelevator.dao.JDBCLandmarkDAO;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Landmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@CrossOrigin
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

    @RequestMapping(path = "/searchLandMark", method = RequestMethod.GET)
    public List<Landmark> searchForLandmark(@RequestParam String landmark_name){
    return landmarkDAO.searchForLandmark(landmark_name);
}

}

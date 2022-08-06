package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JDBCLandmarkDAO implements LandmarkDAO {

    private final JdbcTemplate jdbcTemplate;

    public JDBCLandmarkDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Landmark> retrieveAllLandmark(){

        List<Landmark> landmarkList = new ArrayList<>();
        String sql = "SELECT landmark_id,address_id,landmark_name, landmark_description" +
                "FROM landmark";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            Landmark landmark = mapRowToLandmark(results);
            landmarkList.add(landmark);

        }
        return landmarkList;
    }

//    @Override
//    public List<Landmark> retrieveAllLandmark() {
//        return null;
//    }

    public List<Landmark> searchForLandmark() {
        //implement searchForLandmark when database is done
        return null;
    }

    private Landmark mapRowToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark();

        landmark.setLandmark_name(results.getString("landmark_name"));
        landmark.setLandmark_id(results.getInt("landmark_id"));
        landmark.setAddress_id(results.getInt("address_id"));
        landmark.setLandmark_description(results.getString("landmark_description"));
        return landmark;
    }
}

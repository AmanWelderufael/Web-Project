package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCLandmarkDAO implements LandmarkDAO {


    private final JdbcTemplate jdbcTemplate;

    public JDBCLandmarkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Landmark> retrieveAllLandmark(){

        List<Landmark> landmarkList = new ArrayList<>();
        String sql = "select * from landmark";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Landmark landmark = mapRowToLandmark(results);
            landmarkList.add(landmark);

        }
        return landmarkList;
    }



//    public List<Landmark> searchForLandmark(String landmark_name) {
//        //implement searchForLandmark when database is done
//        List<Landmark> landmarkList = new ArrayList<>();
//        String sql = "SELECT * " +
//                "FROM landmark " +
//                "WHERE landmark_name = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmark_name);
//        if(results.next()) {
//            Landmark landmark = mapRowToLandmark(results);
//            landmarkList.add(landmark);
//
//            return landmarkList;
//        }
//        return null;
//    }

    private Landmark mapRowToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark();


        landmark.setLandmark_name(results.getString("landmark_name"));
        landmark.setLandmark_id(results.getInt("landmark_id"));
        landmark.setAddress_id(results.getInt("address_id"));
        landmark.setLandmark_description(results.getString("landmark_description"));
        return landmark;
    }
}

package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
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
        String sql = "select address.*, landmark.*\n" +
                "from landmark\n" +
                "join address on landmark.address_id = address.address_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Landmark landmark = mapRowToLandmark(results);
            landmarkList.add(landmark);

        }
        return landmarkList;
    }



    public List<Landmark> searchForLandmark(String landmark_name) {
        //implement searchForLandmark when database is done
        // fix sql when pulled
        List<Landmark> landmarkList = new ArrayList<>();
        String sql = "select address.*, landmark.*\n" +
                "from landmark\n" +
                "WHERE landmark_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmark_name);
        if(results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarkList.add(landmark);

            return landmarkList;
        }
        return null;
    }

    private Landmark mapRowToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark();


        landmark.setLandmark_name(results.getString("landmark_name"));
        landmark.setLandmark_id(results.getInt("landmark_id"));
        landmark.setAddress_id(results.getInt("address_id"));
        landmark.setLandmark_description(results.getString("landmark_description"));
        landmark.setStreet_number(results.getInt("street_number"));
        landmark.setStreet_name(results.getString("street_name"));
        landmark.setCity_name(results.getString("city_name"));
        landmark.setState_name(results.getString("state_name"));
        landmark.setZip_code(results.getInt("zip_code"));
        landmark.setLatitude(results.getFloat("latitude"));
        landmark.setLongitude(results.getFloat("longitude"));
        return landmark;
    }


}

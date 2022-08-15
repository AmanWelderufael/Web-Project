package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCItineraryDAO implements ItineraryDAO{
    private final JdbcTemplate jdbcTemplate;

    public JDBCItineraryDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //This will create itinerary
    @Override
    public void createItinerary(int userId, Itinerary itinerary){
        String sqlItinerary = "INSERT INTO itinerary (user_id, itinerary_name, starting_landmark_id) VALUES (? , ?, ?)";

        jdbcTemplate.update(sqlItinerary,userId, itinerary.getItinerary_name(), itinerary.getStarting_landmark_id());
    }

    @Override
    public void addToItinerary(int itineraryId, int landmarkId){
        String sql = "INSERT INTO landmark_itinerary (itinerary_id, landmark_id) VALUES (?, ?)";
        jdbcTemplate.update(sql,itineraryId, landmarkId);
    }

    //This will delete itinerary
    //Think of other ways to delete besides landmarkid

    @Override
    public void deleteItinerary(int landmarkid){

        String sqlToDelete = "DELETE FROM itinerary WHERE starting_landmark_id = ?";

        jdbcTemplate.update(sqlToDelete,landmarkid);
    }

    @Override
    public List<Itinerary> getItinerariesForUser(int userId){

        List<Itinerary> itineraries = new ArrayList<>();
        String sql = "select * from itinerary where itinerary.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itineraries.add(itinerary);
        }
        return itineraries;
    }
    public List<Landmark> getLandmarksOnItinerary(int itineraryId){
        List<Landmark> landmarks = new ArrayList<>();
        String sql = "\n" +
                "select address.*, landmark.*\n" +
                "from landmark\n" +
                "join landmark_itinerary on landmark.landmark_id = landmark_itinerary.landmark_id\n" +
                "join itinerary on itinerary.itinerary_id = landmark_itinerary.itinerary_id\n" +
                "join address on landmark.address_id = address.address_id\n" +
                "where itinerary.itinerary_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
        while(results.next()){
            Landmark landmark = mapRowToLandmark(results);
            landmarks.add(landmark);

        }
        return landmarks;

    }


    private Itinerary mapRowToItinerary(SqlRowSet results) {
        Itinerary itinerary = new Itinerary();

        itinerary.setItinerary_id(results.getInt("Itinerary_id"));
        itinerary.setItinerary_name(results.getString("Itinerary_name"));
        itinerary.setStarting_landmark_id(results.getInt("starting_landmark_id"));
        itinerary.setUser_id(results.getInt("user_id"));

        return itinerary;

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

        //might need to delete
//        landmark.setItinerary_id(results.getInt("itinerary_id"));
//        landmark.setUser_id(results.getInt("user_id"));
//        landmark.setItinerary_name(results.getString("itinerary_name"));
//        landmark.setStarting_landmark_id(results.getInt("starting_landmark_id"));
        return landmark;
    }
}



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
        String sqlItinerary = "INSERT INTO itinerary (user_id, itinerary_name) VALUES (? , ?)";

        jdbcTemplate.update(sqlItinerary,userId, itinerary.getItinerary_name());
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

    private Itinerary mapRowToItinerary(SqlRowSet results) {
        Itinerary itinerary = new Itinerary();

        itinerary.setItinerary_id(results.getInt("Itinerary_id"));
        itinerary.setItinerary_name(results.getString("Itinerary_name"));
        itinerary.setStarting_landmark_id(results.getInt("starting_landmark_id"));
        itinerary.setUser_id(results.getInt("user_id"));

        return itinerary;

    }
}

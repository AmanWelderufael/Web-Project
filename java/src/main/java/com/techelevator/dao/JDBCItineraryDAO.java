package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JDBCItineraryDAO implements ItineraryDAO{
    private final JdbcTemplate jdbcTemplate;

    public JDBCItineraryDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //This will create itinerary
    @Override
    public void createItinerary(int landmarkId,int userId){
        String sqlItinerary = "INSERT INTO itinerary (starting_landmark_id, user_id) VALUES (? , ?)";

        jdbcTemplate.update(sqlItinerary,landmarkId,userId);
    }

    //This will delete itinerary
    //Think of other ways to delete besides landmarkid

    @Override
    public void deleteItinerary(int landmarkid){

        String sqlToDelete = "DELETE FROM itinerary WHERE starting_landmark_id = ?";

        jdbcTemplate.update(sqlToDelete,landmarkid);
    }
}

package com.techelevator.model;

public class Landmark {

    private int landmark_id;
    private int address_id;
    private String landmark_name;
    private String description;



//    public Landmark (int landmark_id, int address_id, String landmark_name, String description) {
//        this.address_id = address_id;
//        this.landmark_id = landmark_id;
//        this.landmark_name = landmark_name;
//        this.description = description;
//    }

    public int getLandmark_id() {
        return landmark_id;
    }

    public void setLandmark_id(int landmark_id) {
        this.landmark_id = landmark_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getLandmark_name() {
        return landmark_name;
    }

    public void setLandmark_name(String landmark_name) {
        this.landmark_name = landmark_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

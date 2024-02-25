package com.example.demo.model;

public class Trajectory {
    private Long id;
    private Long taxiId;
    private String date;
    private double longitude;
    private double latitude;

    // Constructor
    public Trajectory(Long id, Long taxiId, String date, double longitude, double latitude) {
        this.id = id;
        this.taxiId = taxiId;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Long taxiId) {
        this.taxiId = taxiId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
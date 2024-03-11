package com.example.demo.dto;
import com.example.demo.dto.TaxiLastLocationDTO;



public class TaxiLastLocationDTO {
    private Long id;
    private String plate;
    private double latitude;
    private double longitude;
    private String dateTime;

    // Constructores
    public TaxiLastLocationDTO() {}

    public TaxiLastLocationDTO(Long id, String plate, double latitude, double longitude, String dateTime) {
        this.id = id;
        this.plate = plate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
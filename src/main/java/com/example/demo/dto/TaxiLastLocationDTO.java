package com.example.demo.dto;
import com.example.demo.dto.TaxiLastLocationDTO;


import java.time.LocalDateTime;

public class TaxiLastLocationDTO {
    private Long id;
    private Long taxiId;
    private String plate;
    private LocalDateTime date;
    private double latitude;
    private double longitude;

    // Constructores
    public TaxiLastLocationDTO() {}

    public TaxiLastLocationDTO(Long id, Long taxiId, LocalDateTime date, double latitude, double longitude) {
        this.id = id;
        this.taxiId = taxiId;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TaxiLastLocationDTO(Long id, Long id1, String plate, LocalDateTime date, Double latitude, Double longitude) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
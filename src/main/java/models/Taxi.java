package com.example.demo.model;

public class Taxi {
    private Long id;
    private String plateNumber;

    // Constructor
    public Taxi(Long id, String plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
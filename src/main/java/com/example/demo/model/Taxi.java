package com.example.demo.model;


import jakarta.persistence.*;


@Entity
@Table(name = "taxis")
public class Taxi {


    @Id
    @Column(name= "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "plate")
    private String plate;

    //@OneToMany(mappedBy="taxi")
    //private Set<Trajectories> trajectories;

    // Constructor vacío requerido por JPA
    public Taxi() {}

    // Constructor con parámetros
    public Taxi(Long id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    //Getters y setters
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
}
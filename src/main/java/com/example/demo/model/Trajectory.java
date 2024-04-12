package com.example.demo.model;
// Importación de las anotaciones necesarias de JPA (Java Persistence API) y OffsetDateTime para manejar fechas con información de zona horaria
import jakarta.persistence.*;

import java.time.OffsetDateTime;
// La anotación @Entity indica que esta clase es una entidad JPA y se mapea a una tabla en la base de datos

@Entity
@Table(name = "trajectories")

public class Trajectory {


    //Atributos
    @Id
    // La anotación @GeneratedValue especifica cómo se generará el valor de esta columna, en este caso, se generará automáticamente por la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // La anotación @ManyToOne especifica que esta relación es de muchos a uno con la entidad Taxi

    @ManyToOne()
    // La anotación @JoinColumn especifica el nombre de la columna en la tabla de la base de datos que se utilizará para la relación con la entidad Taxi
    @JoinColumn(name= "taxi_id")
    // Atributos adicionales para la fecha, latitud y longitud de la trayectoria
    private Taxi taxi;

    // Atributo para almacenar la fecha y hora de la trayectoria, utilizando OffsetDateTime para incluir información de zona horaria
    private OffsetDateTime date;

    // Atributos para almacenar la latitud y longitud de la ubicación de la trayectoria

    private double latitude;


    private double longitude;


    // Constructor vacío requerido por JPA para fines de reflexión y persistencia
    public Trajectory() {}

    // Constructor con parámetros para facilitar la creación de instancias de la clase Trajectory
    public Trajectory(long id, Taxi taxi, OffsetDateTime date, double latitude, double longitude) {
        this.id = id;
        this.date=date;
        this.latitude= latitude;
        this.longitude=longitude;
        this.taxi= taxi;
    }

    // Getters y setters para acceder y modificar los campos privados de la clase Trajectory
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Taxi getTaxi() { return taxi;}
    public void setTaxi(Taxi taxi) {this.taxi = taxi;}

    public OffsetDateTime getDate() { return date;}

    public void setDate(OffsetDateTime date) {this.date = date;}

    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLongitude() {return longitude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}
}
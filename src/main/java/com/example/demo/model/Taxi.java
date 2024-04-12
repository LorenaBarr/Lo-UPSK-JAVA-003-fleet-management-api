package com.example.demo.model;

// Importación de las anotaciones necesarias de JPA (Java Persistence API)
import jakarta.persistence.*;

// La anotación @Entity indica que esta clase es una entidad JPA y se mapea a una tabla en la base de datos
@Entity
// La anotación @Table especifica el nombre de la tabla en la base de datos que se utilizará para mapear esta entidad
@Table(name = "taxis")
public class Taxi {

    // La anotación @Id indica que este campo es la clave primaria de la entidad
    @Id
    // La anotación @Column especifica el nombre de la columna en la tabla de la base de datos
    @Column(name= "id")

    private Long id;

    @Column(name= "plate")
    private String plate;



    // Constructor vacío requerido por JPA para fines de reflexión y persistencia
    public Taxi() {}

    // Constructor con parámetros para facilitar la creación de instancias de la clase Taxi
    public Taxi(Long id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    // Getters y setters para acceder y modificar los campos privados de la clase Taxi

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
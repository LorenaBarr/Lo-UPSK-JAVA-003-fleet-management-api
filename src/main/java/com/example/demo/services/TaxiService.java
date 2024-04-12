package com.example.demo.services;


import com.example.demo.model.Taxi;
import com.example.demo.repositories.TaxiRepository;
// Importa la anotación Autowired de Spring para realizar la inyección de dependencias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// Importa la anotación Service de Spring para indicar que esta clase es un servicio
import org.springframework.stereotype.Service;



// Definición de la clase TaxiService como un servicio
@Service
public class TaxiService {
    private final TaxiRepository taxiRepository; // Inyección del repositorio TaxiRepository

    // Constructor de la clase con inyección de dependencias del repositorio TaxiRepository
    @Autowired
    public TaxiService (TaxiRepository taxiRepository) {
        this.taxiRepository= taxiRepository;
    }
    // Método para obtener todos los taxis paginados
    public Page<Taxi> getAllTaxis(Pageable pageable){

        return taxiRepository.findAll(pageable); // Utiliza el método findAll del repositorio TaxiRepository para obtener todos los taxis paginados
    }
}
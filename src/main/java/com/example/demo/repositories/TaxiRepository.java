package com.example.demo.repositories;
// Importación de la clase Taxi desde el paquete com.example.demo.model
import com.example.demo.model.Taxi;
// Importación de la interfaz PagingAndSortingRepository desde el framework Spring Data
import org.springframework.data.repository.PagingAndSortingRepository;

// Definición de la interfaz TaxiRepository que extiende de PagingAndSortingRepository y se especializa para la entidad Taxi
public interface TaxiRepository extends PagingAndSortingRepository<Taxi, Long> {



}


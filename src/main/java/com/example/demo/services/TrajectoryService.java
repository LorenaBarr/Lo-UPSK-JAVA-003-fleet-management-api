// TrajectoryService.java
package com.example.demo.services;

import com.example.demo.model.Trajectory;
import com.example.demo.repositories.TrajectoriesRepository;
// Importa la anotación Autowired de Spring para realizar la inyección de dependencias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
// Importa la clase PageRequest de Spring Data para crear solicitudes de páginas
import org.springframework.data.domain.PageRequest;
// Importa la anotación Service de Spring para indicar que esta clase es un servicio
import org.springframework.stereotype.Service;
// Importa la clase PageImpl de Spring Data para crear implementaciones de páginas
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;

// Definición de la clase TrajectoryService como un servicio
@Service
public class TrajectoryService {// Inyección del repositorio TrajectoriesRepository

    private final TrajectoriesRepository trajectoriesRepository;
    // Constructor de la clase con inyección de dependencias del repositorio TrajectoriesRepository
    @Autowired
    public TrajectoryService(TrajectoriesRepository trajectoriesRepository ) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    public Page<Trajectory> getAllTrajectories(Pageable pageable){
        return trajectoriesRepository.findAll(pageable);
    }
    // Método para buscar trayectorias por ID de taxi y fecha
    public Page<Trajectory> findByDateAndId(int taxi_id, String dateString, Pageable pageable) {
        return trajectoriesRepository.findByTaxiIdAndDate(taxi_id, dateString, pageable);
    }

    // Método auxiliar para crear una solicitud de página
    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
    // Método para obtener la última ubicación de cada taxi
    public Page<Trajectory> getLastLocation(int page, int size) {
        Pageable pageRequest = createPageRequestUsing(page, size);  // Crea una solicitud de página usando los parámetros de página y tamaño


        List<Trajectory> allCustomers = trajectoriesRepository.findLastLocation(); // Obtiene todas las ubicaciones de los taxis
        int start = (int) pageRequest.getOffset(); // Calcula el índice de inicio de los resultados en la lista completa
        int end = Math.min((start + pageRequest.getPageSize()), allCustomers.size()); // Calcula el índice de fin de los resultados en la lista completa

        List<Trajectory> pageContent = allCustomers.subList(start, end); // Obtiene la lista de ubicaciones para la página actual

        List<Trajectory> lastLocation = trajectoriesRepository.findLastLocation();// Obtiene todas las últimas ubicaciones de los taxis
        return new PageImpl<>( pageContent, pageRequest, lastLocation.size()); // Crea y devuelve una implementación de página utilizando los resultados de la página actual y el tamaño total de las ubicaciones
    }
}
package com.example.demo.repositories;
import com.example.demo.model.Trajectory;
// Importa la interfaz Page de Spring Data para representar una página de resultados paginados
import org.springframework.data.domain.Page;
//Importa la interfaz Pageable de Spring Data para representar la información de paginación y ordenamiento
import org.springframework.data.domain.Pageable;
 //Importa la anotación Query de Spring Data JPA para definir consultas personalizadas utilizando JPQL o SQL nativo
import org.springframework.data.jpa.repository.Query;
// Importa la interfaz PagingAndSortingRepository de Spring Data para proporcionar métodos adicionales para paginación y ordenamiento de resultados
import org.springframework.data.repository.PagingAndSortingRepository;
// Importa la anotación Param de Spring Data para especificar parámetros en consultas personalizadas definidas con Query
import java.util.List; // Importa la interfaz List de Java para representar una lista de elementos
import org.springframework.data.repository.query.Param;
import java.util.List; // Importa la interfaz List de Java para representar una lista de elementos



// Definición de la interfaz TrajectoriesRepository que extiende de PagingAndSortingRepository y se especializa para la entidad Trajectory
public interface TrajectoriesRepository extends PagingAndSortingRepository<Trajectory, Long> {
    // Definición de una consulta personalizada utilizando JPQL para buscar trayectorias por ID de taxi y fecha
    @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxi_id AND TO_CHAR(t.date, 'YYYY-MM-DD') = :date", nativeQuery = true)
    Page<Trajectory> findByTaxiIdAndDate(@Param("taxi_id") int taxi_id, @Param("date") String date, Pageable pageable);
    // Definición de una consulta personalizada utilizando SQL nativo para encontrar la última ubicación de cada taxi
    @Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE FROM (SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE, ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) AS rn FROM TRAJECTORIES ) AS subquery WHERE rn = 1", nativeQuery = true)
    List<Trajectory> findLastLocation();


}
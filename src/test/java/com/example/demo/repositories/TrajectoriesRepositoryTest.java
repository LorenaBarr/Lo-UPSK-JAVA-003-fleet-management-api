package com.example.demo.repositories;

import com.example.demo.model.Trajectory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
public class TrajectoriesRepositoryTest {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    @Test
    void testFindByTaxiIdAndDate() {
        // Datos de prueba
        int taxiId = 9275;
        String date = "2008-02-02";
        Pageable pageable = PageRequest.of(0, 1);

        // Ejecutar método findByTaxiIdAndDate
        Page<Trajectory> trajectoriesPage = trajectoriesRepository.findByTaxiIdAndDate(taxiId, date, pageable);

        // Convertir la página de trayectorias a una lista
        assertNotNull(trajectoriesPage);
        List<Trajectory> trajectories = trajectoriesPage.getContent();

        // Verificar si se encontraron trayectorias
        assertNotNull(trajectories);
        // Aquí puedes agregar más aserciones para verificar los detalles de las trayectorias encontradas
    }

    @Test
    void testFindLastLocation() {
        // Ejecutar método findLastLocation
        List<Trajectory> lastLocations = trajectoriesRepository.findLastLocation();

        // Verificar si se encontraron las últimas ubicaciones
        assertNotNull(lastLocations);
        // Aquí puedes agregar más aserciones para verificar los detalles de las últimas ubicaciones encontradas
    }
}

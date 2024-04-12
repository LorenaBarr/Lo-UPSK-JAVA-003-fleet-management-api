//este test garantiza que el método findLastLocation del repositorio TrajectoriesRepository funcione correctamente
// al devolver la lista de las últimas ubicaciones registradas de las trayectorias.
package com.example.demo.repositories;

import com.example.demo.model.Trajectory;
import org.junit.jupiter.api.Test;// Importa la anotación Test de JUnit Jupiter para definir métodos de prueba
import org.springframework.beans.factory.annotation.Autowired;// Importa la anotación Autowired de Spring para realizar la inyección de dependencias
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Importa la anotación AutoConfigureMockMvc para configurar MockMvc automáticamente
import org.springframework.boot.test.context.SpringBootTest;// Importa la anotación SpringBootTest para cargar la aplicación Spring Boot para pruebas
import org.springframework.boot.test.mock.mockito.MockBean;// Importa la anotación MockBean de Spring Boot para crear un mock del bean
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;// Importa la clase MockMvc de Spring Test para realizar solicitudes HTTP simuladas
import java.util.ArrayList;// Importa la clase ArrayList de Java para representar una lista dinámica de elementos
import java.util.List; // Importa la interfaz List de Java para representar una lista de elementos
import static org.mockito.Mockito.when; // Importa el método when de Mockito para configurar comportamientos de mock
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importa el método get de MockMvcRequestBuilders para construir una solicitud GET simulada
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importa el método jsonPath de MockMvcResultMatchers para realizar verificaciones JSON en las respuestas
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;// Importa el método status de MockMvcResultMatchers para realizar verificaciones de estado en las respuestas


// Anotaciones para la prueba de la clase TrajectoriesRepository
@SpringBootTest // Indica que esta clase de prueba es una prueba de integración y cargará la aplicación Spring Boot
@AutoConfigureMockMvc // Configura automáticamente MockMvc para la prueba
class TrajectoriesRepositoryTest {
    // Inyecta el bean MockMvc en el campo mvc
    @Autowired
    private MockMvc mvc;
    // Crea un mock del bean TrajectoriesRepository y lo inyecta en el campo trajectoriesRepository
    @MockBean
    private TrajectoriesRepository trajectoriesRepository;
    // Método de prueba para verificar el método findLastLocation de TrajectoriesRepository
    @Test
    void testLastTrajectories() throws Exception{
        // Configuración de la página de prueba y la lista de trayectorias
        Pageable pageable = Pageable.ofSize(1).withPage(1);
        List<Trajectory> trajectories = new ArrayList<>();
        trajectories.add(new Trajectory());
        trajectories.add(new Trajectory());
        trajectories.add(new Trajectory());
        // Configuración del comportamiento del mock del bean TrajectoriesRepository
        when (trajectoriesRepository.findLastLocation()).thenReturn(trajectories);
// Realiza una solicitud HTTP simulada GET a "/trajectories/last-Location"
        // con parámetros de página y tamaño de página
        this.mvc.perform(get("/trajectories/last-Location")

                        .param("Page", "1")
                        .param("Size", "1"))
                // Verifica que el estado de la respuesta sea OK (200)
                .andExpect(status().isOk())
                // Verifica que el contenido de la respuesta sea un array
                .andExpect(jsonPath("$.content").isArray())
                // Verifica que la longitud del array de contenido sea igual al tamaño de la lista de trayectorias
                .andExpect(jsonPath("$.content.length()").value(trajectories.size()))
                // Retorna el resultado de la solicitud simulada
                .andReturn();



    }

}
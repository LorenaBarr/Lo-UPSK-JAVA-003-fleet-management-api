//este test garantiza que los endpoints relacionados con los taxis en la
// aplicación funcionen correctamente y devuelvan respuestas esperadas
package com.example.demo;

import com.example.demo.repositories.TaxiRepository;
import org.junit.jupiter.api.DisplayName; // Importa la anotación DisplayName de JUnit Jupiter para definir nombres descriptivos de pruebas
import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit Jupiter para definir métodos de prueba
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring para realizar la inyección de dependencias
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Importa la anotación AutoConfigureMockMvc para configurar MockMvc automáticamente
import org.springframework.boot.test.context.SpringBootTest; // Importa la anotación SpringBootTest para cargar la aplicación Spring Boot para pruebas
import org.springframework.test.web.servlet.MockMvc; // Importa la clase MockMvc de Spring Test para realizar solicitudes HTTP simuladas
import org.springframework.test.web.servlet.MvcResult; // Importa la clase MvcResult de Spring Test para representar el resultado de una solicitud MVC
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importa el método get de MockMvcRequestBuilders para construir una solicitud GET simulada
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importa el método jsonPath de MockMvcResultMatchers para realizar verificaciones JSON en las respuestas
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importa el método status de MockMvcResultMatchers para realizar verificaciones de estado en las respuestas
import static org.junit.jupiter.api.Assertions.assertEquals; // Importa el método assertEquals de JUnit Jupiter para realizar afirmaciones

// Definición de la clase ApiTaxisApplicationTest para pruebas de integración
@SpringBootTest // Indica que esta clase de prueba es una prueba de integración y cargará la aplicación Spring Boot
@AutoConfigureMockMvc // Configura automáticamente MockMvc para la prueba

class ApiTaxisApplicationTest {
    // Inyecta el bean MockMvc en el campo mockMvc
    @Autowired
    private MockMvc mockMvc;
    // Inyecta el bean TaxiRepository en el campo taxiRepository
    @Autowired
    private TaxiRepository taxiRepository;



// Método de prueba para verificar el contexto de la aplicación

    @Test
    @DisplayName("Comprobar el primer endpoint: Tex...")
    void context() throws Exception {
        // Realiza una solicitud HTTP simulada GET al endpoint "/taxi/all?page=1" y verifica que el estado de la respuesta sea OK (200)
        mockMvc.perform(get("/taxi/all?page=1")).andExpect(status().isOk());

    }
    // Método de prueba para verificar el controlador Trajectories
    @Test
    @DisplayName("test Trajectories")
    void testControllerTrajectories() throws Exception {
        // Configuración de parámetros para la solicitud simulada
        String taxi_id = "6418";
        String dateString = "2008-02-02";
        String intPage ="0";
        String pageSize = "10";
        // Realiza una solicitud HTTP simulada GET al endpoint "/trajectories/byDateAndId" con los parámetros configurados
        MvcResult mvcResult = this.mockMvc.perform(get("/trajectories/byDateAndId")
                        .param("taxi_id", taxi_id)
                        .param("date", dateString)
                        .param("intPage", intPage)
                        .param("pageSize", pageSize))
                // Verifica que el estado de la respuesta sea OK (200)
                .andExpect(status().isOk())
                // Verifica que el valor del número de página en la respuesta coincida con el valor configurado
                .andExpect(jsonPath("$.pageable.pageNumber").value(intPage))
                // Verifica que el valor del tamaño de página en la respuesta coincida con el valor configurado
                .andExpect(jsonPath("$.pageable.pageSize").value(pageSize))
                // Retorna el resultado de la solicitud simulada
                .andReturn();
        // Verifica que el tipo de contenido de la respuesta sea "application/json"
        assertEquals("application/json", mvcResult.getResponse().getContentType());

    }

}
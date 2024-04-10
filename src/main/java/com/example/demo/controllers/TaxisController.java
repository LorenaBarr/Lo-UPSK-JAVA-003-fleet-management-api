package com.example.demo.controllers;

import com.example.demo.services.TaxiService;
import com.example.demo.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

// Anotación para indicar que esta clase es un controlador REST y define la ruta base para todas las solicitudes
@RestController
@RequestMapping("/taxi")
public class TaxisController {
    // Inyección del servicio TaxiService en el controlador
    private final TaxiService taxiService;
    public TaxisController (TaxiService taxiService) {

        this.taxiService = taxiService;
    }

    // Documentación para la operación de obtener todos los taxis
    @Operation(summary = "Get all taxis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taxi.class)) }),
            @ApiResponse(responseCode = "400", description = "Object Taxi invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxi not found",
                    content = @Content)
    })

    // Método para manejar la solicitud GET para obtener todos los taxis
    @GetMapping("/all")
    public Page<Taxi> getAllTaxis( @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                   @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {
        // Parámetro para indicar el número de página, con un valor predeterminado de 0 si no se proporciona
        // Parámetro para indicar el número de elementos por página, con un valor predeterminado de 10 si no se proporciona
        // Creación de un objeto Pageable para la paginación
        Pageable pageable = PageRequest.of(page, size);
        // Llamada al servicio para obtener todos los taxis con paginación
        return taxiService.getAllTaxis(pageable);
    }

}
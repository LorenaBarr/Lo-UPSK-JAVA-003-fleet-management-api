package com.example.demo.controllers;

import com.example.demo.dto.TaxiLastLocationDTO;
import com.example.demo.model.Trajectory;
import com.example.demo.services.TrajectoryService;
import com.example.demo.services.TaxiService;
import com.example.demo.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxisController {

    @Autowired
    private TaxiService taxiService;

    @Autowired
    private TrajectoryService trajectoryService;

    @Operation(summary = "Obtener todos los taxis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontraron todos los taxis",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taxi.class)) }) })
    @GetMapping("/last-location") // Aquí añadí "/last-location"
    public ResponseEntity<Page<TaxiLastLocationDTO>> getLastLocationOfTaxis(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<TaxiLastLocationDTO> lastLocations = taxiService.getLastLocationOfTaxis(page, size);
        return ResponseEntity.ok(lastLocations);
    }
}
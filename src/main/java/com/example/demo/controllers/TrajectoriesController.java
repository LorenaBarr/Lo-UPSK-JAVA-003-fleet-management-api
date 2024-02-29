package com.example.demo.controllers;

import com.example.demo.model.Trajectory;
import com.example.demo.services.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;



import java.util.List;

@RestController
@RequestMapping("/api/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoryService trajectoryService;

    @Operation(summary = "Obtener todas las trayectorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontraron todas las trayectorias",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }) })

    @GetMapping
    public List<Trajectory> getAllTrajectories() {
        return trajectoryService.getAllTrajectories();
    }
}

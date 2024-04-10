
package com.example.demo.controllers;
import com.example.demo.model.Trajectory;
import com.example.demo.services.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


// Anotación para indicar que esta clase es un controlador REST y define la ruta base para todas las solicitudes
@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {
    @Autowired
    // Inyección del servicio TaxiService en el controlador
    private final TrajectoryService trajectoriesService;

    public TrajectoriesController (TrajectoryService trajectoriesService) {
        this.trajectoriesService= trajectoriesService;
    }
    // Documentación para la operación de obtener todos los taxis
    @Operation(summary = "Get-All-Trajectories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the trajectories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }),
            @ApiResponse(responseCode = "400", description = "Object trajectories invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Trajectories not found",
                    content = @Content)
    })

// Método para manejar la solicitud GET para obtener todas las trayectorias
    @GetMapping("/all")
    public Page<Trajectory> getAllTrajectories (@Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                                  @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {

        // Creación de un objeto Pageable para la paginación
        Pageable pageable = PageRequest.of(page, size);
        // Llamada al servicio para obtener todas las trayectorias con paginación
        return trajectoriesService.getAllTrajectories (pageable);
    }

    @Operation(summary = "Get-Locations-Of-A-Taxi-By-ID-And-Date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi locations",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }),

            @ApiResponse(responseCode = "404", description = "Taxi locations not found",
                    content = @Content)
    })

    // Documentación para la operación de obtener las ubicaciones de un taxi por ID y fecha
    @GetMapping ("byDateAndId")
    public Page<Trajectory> findByDateAndId (

            @Parameter(description = "Taxi ID") @RequestParam(name = "taxi_id") int taxi_id,
            @Parameter(description = "Date in format YYYY-MM-DD") @RequestParam (name = "date") String dateString ,
            @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {
// parametros para indicar el ID, fecha en formatO YYYY-MM-DD, numero de la pagina con valores pretederminados de 0 si no se proporciona, numero de elementos de la paginacion
        Pageable pageable = PageRequest.of(page, size);
        return trajectoriesService.findByDateAndId (taxi_id, dateString,pageable);
    }

    // Documentación para la operación de obtener las últimas ubicaciones de los taxis
    @Operation(summary = "Get-Last-Locations ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi last locations",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }),

            @ApiResponse(responseCode = "404", description = "Taxi last locations not found",
                    content = @Content)
    })

// Método para manejar la solicitud GET para obtener las últimas ubicaciones de los taxis
    @GetMapping ("last-Location")
    public Page<Trajectory> getLastLocation (


            @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        return trajectoriesService.getLastLocation(page, size);
    }


}
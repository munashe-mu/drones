package com.umlimi.drones.api;

import com.umlimi.drones.service.drones.DroneDto;
import com.umlimi.drones.service.drones.DroneRequest;
import com.umlimi.drones.service.drones.DroneService;
import com.umlimi.drones.service.medication.MedicationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/drone")
public class DroneRestController {
    private final DroneService droneService;

    @Operation(summary = "Register Drone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Drone Registered Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDto.class))})
    })
    @PostMapping("/register")
    public ResponseEntity<DroneDto> registerDrone(@RequestBody DroneRequest droneRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(droneService.registerDrone(droneRequest));
    }

    @Operation(summary = "Find drone by drone id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Drone Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDto.class))}),
            @ApiResponse(responseCode = "404", description = "Drone Not Found",
                    content = @Content)})
    @GetMapping("/id/{droneId}")
    public ResponseEntity<DroneDto> getDroneById(@PathVariable Long droneId) {
        return ResponseEntity.ok().body(droneService.findDroneById(droneId));
    }

    @Operation(summary = "Load Drone With Medication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Drone Loaded Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDto.class))})
    })
    @PostMapping("/load-drone")
    public ResponseEntity<DroneDto> loadDrone(@RequestBody String medicationCode){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(droneService.loadDroneWithMedication(medicationCode));
    }

    @Operation(summary = "Get all Drones Available for Loading")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Drones Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDto.class))}),
            @ApiResponse(responseCode = "404", description = "Drones Not Found",
                    content = @Content)})
    @GetMapping("/all/available")
    public ResponseEntity<List<DroneDto>> checkAvailableDronesForLoading() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(droneService.checkAvailableDronesForLoading());
    }

    @Operation(summary = "Get Medication Loaded Per Drone By Drone Serial Number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medication found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DroneDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Medication not found",
                    content = @Content) })
    @GetMapping("/medication/{serialNumber}")
    public ResponseEntity<MedicationDto> checkMedicationLoadedPerDrone(@PathVariable String serialNumber){
        return ResponseEntity.ok(droneService.checkMedicationForDrone(serialNumber));
    }
}

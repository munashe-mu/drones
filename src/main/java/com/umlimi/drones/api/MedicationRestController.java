package com.umlimi.drones.api;

import com.umlimi.drones.service.medication.MedicationDto;
import com.umlimi.drones.service.medication.MedicationRequest;
import com.umlimi.drones.service.medication.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author MUNASHE MURIMI
 * @created 31/1/2023
 **/
@RestController
@RequestMapping("v1/medication")
@RequiredArgsConstructor
public class MedicationRestController {
    private final MedicationService medicationService;

    @Operation(summary = "Save Medication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Medication saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicationDto.class)) })})
    @PostMapping("/save")
    public ResponseEntity<MedicationDto> saveMedication(@RequestBody MedicationRequest medicationRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicationService.saveMedication(medicationRequest));
    }
    @Operation(summary = "Find Medication By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medication found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicationDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Medication not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto> findMedicationById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(medicationService.findMedicationById(id));
    }
}

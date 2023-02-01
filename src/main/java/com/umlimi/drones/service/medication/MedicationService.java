package com.umlimi.drones.service.medication;


/**
 * @author MUNASHE MURIMI
 * @created 29/1/2023
 **/
public interface MedicationService {
    MedicationDto saveMedication(MedicationRequest medicationRequest);

    MedicationDto findMedicationById(Long id);
}

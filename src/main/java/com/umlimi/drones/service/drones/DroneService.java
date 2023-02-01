package com.umlimi.drones.service.drones;

import com.umlimi.drones.domain.enums.State;
import com.umlimi.drones.service.medication.MedicationDto;

import java.util.List;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public interface DroneService {
    /**
     * This method registers drone
     * @param droneRequest
     * @return droneDto
     */
    DroneDto registerDrone(DroneRequest droneRequest);

    /**
     * This method finds drone by id
     * @param droneId
     * @return droneDto
     */
   DroneDto findDroneById(Long droneId);

    /**
     * This method checks the availability of drones
     * @param state
     * @return droneDto
     */
   List<DroneDto> checkAvailableDronesForLoading();

    /**
     * This method loads the drone medication
     * @param medicationCode
     * @return droneDto
     */

   DroneDto loadDroneWithMedication(String medicationCode);

    /**
     * This method checks the battery level
     * @param serialNumber
     * @return
     */

   Integer checkBatteryLevel(String serialNumber);

    /**
     * This medication checks the medication loaded for each drone
     * @param serialNumber
     * @return
     */

   MedicationDto checkMedicationForDrone(String serialNumber);

}

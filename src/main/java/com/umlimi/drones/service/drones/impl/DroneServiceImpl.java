package com.umlimi.drones.service.drones.impl;

import com.umlimi.drones.domain.Drone;
import com.umlimi.drones.domain.Medication;
import com.umlimi.drones.domain.enums.State;
import com.umlimi.drones.exceptionhandling.AboveMaximumWeightLimitException;
import com.umlimi.drones.exceptionhandling.DroneNotFoundException;
import com.umlimi.drones.exceptionhandling.FailedToLoadDroneException;
import com.umlimi.drones.persistence.DroneRepository;
import com.umlimi.drones.persistence.MedicationRepository;
import com.umlimi.drones.service.drones.DroneDto;
import com.umlimi.drones.service.drones.DroneRequest;
import com.umlimi.drones.service.drones.DroneService;
import com.umlimi.drones.service.medication.MedicationDto;
import com.umlimi.drones.utils.EntityToDtoMapper;
import com.umlimi.drones.utils.Validations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;
    private final ModelMapper modelMapper;
    private final MedicationRepository medicationRepository;

    @Override
    public DroneDto registerDrone(DroneRequest droneRequest) {
        requireNonNull(droneRequest, "Drone request cannot be null");

        int weightLimit = droneRequest.getWeightLimit();
        if (weightLimit > 500){
            throw new AboveMaximumWeightLimitException(String.format("Weight %s is above the limit of 500.", weightLimit));
        }

        Drone drone =Drone.builder()
                .weightLimit(weightLimit)
                .state(droneRequest.getState())
                .model(droneRequest.getModel())
                .serialNumber(droneRequest.getSerialNumber())
                .batteryCapacity(droneRequest.getBatteryCapacity())
                .build();
        return EntityToDtoMapper.convertToDroneDto(droneRepository.save(drone), modelMapper);
    }

    @Override
    public DroneDto findDroneById(Long droneId) {
        return EntityToDtoMapper.convertToDroneDto(droneRepository.findById(droneId)
                .orElseThrow(()-> new DroneNotFoundException(
                        String.format("Drone with id %s not found",droneId))),modelMapper);
    }

    @Override
    public List<DroneDto> checkAvailableDronesForLoading() {
        return droneRepository.findAllByState(State.IDLE)
                .stream()
                .filter(drone -> drone.getBatteryCapacity() > 25)
                .map(drone -> EntityToDtoMapper.convertToDroneDto(drone, modelMapper))
                .collect(Collectors.toList());
    }

    @Override
    public DroneDto loadDroneWithMedication(String medicationCode) {
        requireNonNull(medicationCode, "Medication code cannot be null");
        Validations.validateCode(medicationCode);
        Optional<Medication> medication = medicationRepository.findByCode(medicationCode);
        Optional<Drone> findDrone = droneRepository.findAllByState(State.IDLE)
                .stream()
                .filter(drone -> drone.getBatteryCapacity() > 25
                        && drone.getWeightLimit() >= medication.get().getWeight())
                .findFirst();

        if (!findDrone.isPresent()){
            throw new FailedToLoadDroneException("Failed to load drone");
        }

        findDrone.get().setState(State.LOADING);
        findDrone.get().setMedication(medication.get());
        return EntityToDtoMapper.convertToDroneDto(droneRepository.save(findDrone.get()), modelMapper);
    }

    @Override
    public Integer checkBatteryLevel(String serialNumber) {
    //    requireNonNull(serialNumber, "Serial number cannot be null");
//        var getDroneDetails = droneRepository.findBySerialNumber(serialNumber)
//                .orElseThrow(()-> new DroneNotFoundException(String.format("Drone with serial number" +
//                        " %s not found", serialNumber)));
//        return getDroneDetails.getBatteryCapacity();
        return null;
    }

    @Override
    public MedicationDto checkMedicationForDrone(String serialNumber) {
        requireNonNull(serialNumber, "Serial number cannot be null");
//        var drone = droneRepository.findBySerialNumber(serialNumber)
//                .orElseThrow(()-> new DroneNotFoundException(String.format("Drone with serial number" +
//                        " %s not found", serialNumber)));
//        return EntityToDtoMapper.convertMedicationDto(drone.getMedication(), modelMapper);
        return null;
    }
}

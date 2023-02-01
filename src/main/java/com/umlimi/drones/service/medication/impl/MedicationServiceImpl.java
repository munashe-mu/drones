package com.umlimi.drones.service.medication.impl;

import com.umlimi.drones.domain.Medication;
import com.umlimi.drones.exceptionhandling.InvalidInputParameterException;
import com.umlimi.drones.exceptionhandling.MedicationNotFoundException;
import com.umlimi.drones.persistence.MedicationRepository;
import com.umlimi.drones.service.medication.MedicationDto;
import com.umlimi.drones.service.medication.MedicationRequest;
import com.umlimi.drones.service.medication.MedicationService;
import com.umlimi.drones.utils.EntityToDtoMapper;
import com.umlimi.drones.utils.Validations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import static java.util.Objects.requireNonNull;

/**
 * @author MUNASHE MURIMI
 * @created 29/1/2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor

public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;
    private final ModelMapper modelMapper;

    @Override
    public MedicationDto saveMedication(MedicationRequest medicationRequest) {
        requireNonNull(medicationRequest, "Medication request cannot be null");

        var checkIfMedicationCodeExists = medicationRepository.findByCode(medicationRequest.getCode());
        if (checkIfMedicationCodeExists.isPresent()){
            throw new InvalidInputParameterException(String.format(
                    "Medication code %s already saved", medicationRequest.getCode()
            ));
        }

        Validations.validateName(medicationRequest.getName());
        Validations.validateCode(medicationRequest.getCode());

        Medication medication  = Medication.builder()
                .code(medicationRequest.getCode())
                .image(medicationRequest.getImage())
                .weight(medicationRequest.getWeight())
                .name(medicationRequest.getName())
                .build();
        return EntityToDtoMapper.convertMedicationDto(medicationRepository.save(medication), modelMapper);
    }

    @Override
    public MedicationDto findMedicationById(Long id) {
        return EntityToDtoMapper.convertMedicationDto(medicationRepository.findById(id).orElseThrow(
                ()-> new MedicationNotFoundException(
                        String.format("Medication with id %s not found", id))), modelMapper);
    }
}

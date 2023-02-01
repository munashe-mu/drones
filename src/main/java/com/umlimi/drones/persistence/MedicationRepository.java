package com.umlimi.drones.persistence;

import com.umlimi.drones.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Optional<Medication> findByCode(String medicationCode);
}

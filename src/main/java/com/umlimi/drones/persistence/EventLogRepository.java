package com.umlimi.drones.persistence;

import com.umlimi.drones.domain.EventLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
public interface EventLogRepository extends JpaRepository<EventLogs, Long> {
   // Page<EventLogs> findAllByDateCreated(LocalDate date, Pageable pageable);
}

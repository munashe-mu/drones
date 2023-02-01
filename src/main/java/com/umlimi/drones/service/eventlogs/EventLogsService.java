package com.umlimi.drones.service.eventlogs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

/**
 * @author MUNASHE MURIMI
 * @created 31/1/2023
 **/
public interface EventLogsService {
    Page<EventLogsDto> filterByDate(LocalDate date, Pageable pageable);
}

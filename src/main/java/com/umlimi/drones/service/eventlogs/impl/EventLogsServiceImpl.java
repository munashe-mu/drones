//package com.umlimi.drones.service.eventlogs.impl;
//
//import com.umlimi.drones.exceptionhandling.EventLogNotFoundException;
//import com.umlimi.drones.persistence.EventLogRepository;
//import com.umlimi.drones.service.eventlogs.EventLogsDto;
//import com.umlimi.drones.service.eventlogs.EventLogsService;
//import com.umlimi.drones.utils.EntityToDtoMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// * @author MUNASHE MURIMI
// * @created 31/1/2023
// **/
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class EventLogsServiceImpl implements EventLogsService {
//    private final EventLogRepository eventLogRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public Page<EventLogsDto> filterByDate(LocalDate date, Pageable pageable) {
//        List<EventLogsDto> eventLogsDtoList = eventLogRepository.findAllByDateCreated(date, pageable)
//                .stream()
//                .map(eventLogs -> EntityToDtoMapper.convertEventLogsDto(eventLogs, modelMapper))
//                .collect(Collectors.toList());
//        if (eventLogsDtoList.isEmpty() && Objects.equals(eventLogsDtoList, null)){
//            throw new EventLogNotFoundException("No events found");
//        }
//        return new PageImpl<>(eventLogsDtoList, pageable, eventLogsDtoList.size());
//    }
//}

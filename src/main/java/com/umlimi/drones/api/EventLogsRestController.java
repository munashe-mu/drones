//package com.umlimi.drones.api;
//
//import com.umlimi.drones.service.eventlogs.EventLogsDto;
//import com.umlimi.drones.service.eventlogs.EventLogsService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//
//import static org.springframework.http.HttpStatus.OK;
//
///**
// * @author MUNASHE MURIMI
// * @created 31/1/2023
// **/
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("v1/log")
//public class EventLogsRestController {
//    private final EventLogsService eventLogsService;
//
//    @Operation(summary = "Filter All Logs By Date")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "AuditEventLog found",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = EventLogsService.class))}),
//            @ApiResponse(responseCode = "404", description = "AuditEventLog not found",
//                    content = @Content)})
//    @GetMapping
//    public ResponseEntity<Page<EventLogsDto>> filterLogsByDate(@RequestParam("date")
//                                                                   @DateTimeFormat(pattern = "dd/MM/yyyy")
//                                                                           LocalDate date,
//                                                               @PageableDefault Pageable pageable) {
//        return ResponseEntity.status(OK)
//                .body(eventLogsService.filterByDate(date, pageable));
//    }
//}
//

package com.metro.Metro_ticket_backend.controller;

import com.metro.Metro_ticket_backend.DTO.StationCreateRequest;
import com.metro.Metro_ticket_backend.Service.StationService;
import com.metro.Metro_ticket_backend.entity.Station;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Station> getStationByid(@PathVariable Long id) {
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Station> CreateStation(@RequestBody StationCreateRequest request) {
        return ResponseEntity.ok(stationService.createStation(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Station> UpdateStation(@PathVariable Long id,
                                                 @RequestBody StationCreateRequest request) {
        return ResponseEntity.ok(stationService.updateStation(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> DeleteStation(@PathVariable Long id) {
        stationService.deleteStationById(id);
        return ResponseEntity.ok("Station deleted successfully");
    }




}

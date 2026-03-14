package com.metro.Metro_ticket_backend.controller;

import com.metro.Metro_ticket_backend.DTO.RouteRequest;
import com.metro.Metro_ticket_backend.Service.RouteService;
import com.metro.Metro_ticket_backend.entity.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Route> addRoute(@RequestBody RouteRequest routeRequest) {
        return ResponseEntity.ok(routeService.createRoute(routeRequest));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody RouteRequest dto) {
        return ResponseEntity.ok(routeService.updateRoute(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok("Route Deleted Successfully");


    }
}
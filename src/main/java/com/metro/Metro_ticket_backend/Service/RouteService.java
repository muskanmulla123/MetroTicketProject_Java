package com.metro.Metro_ticket_backend.Service;

import com.metro.Metro_ticket_backend.DTO.RouteRequest;
import com.metro.Metro_ticket_backend.entity.Route;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface RouteService {
     Route createRoute(RouteRequest routeRequest);

     List<Route> getAllRoutes();

     Route getRouteById(Long id);

     Route updateRoute(Long id, RouteRequest dto);

    void deleteRoute(Long id);
}

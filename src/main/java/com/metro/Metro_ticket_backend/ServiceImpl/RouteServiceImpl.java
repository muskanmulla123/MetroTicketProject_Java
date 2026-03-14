package com.metro.Metro_ticket_backend.ServiceImpl;

import com.metro.Metro_ticket_backend.DTO.RouteRequest;
import com.metro.Metro_ticket_backend.Service.RouteService;
import com.metro.Metro_ticket_backend.entity.Route;
import com.metro.Metro_ticket_backend.entity.Station;
import com.metro.Metro_ticket_backend.repository.RouteRepsitory;
import com.metro.Metro_ticket_backend.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {


    private final RouteRepsitory routeRepsitory;
    private final StationRepository stationRepository;
    @Override
    public Route createRoute(RouteRequest routeRequest) {

        Station src= stationRepository.findById(routeRequest.getStartStationId()).
                orElseThrow(() -> new RuntimeException("source station not found"));

        Station dest=stationRepository.findById(routeRequest.getEndStationId())
                .orElseThrow(()-> new RuntimeException("destination not found"));

        Route route=new Route();
        route.setName(routeRequest.getName());
        route.setStartStation(src);
        route.setEndStation(dest);
        route.setFare(routeRequest.getFare());

        return routeRepsitory.save(route);

    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepsitory.findAll();
    }

    @Override
    public Route getRouteById(Long id) {
        return routeRepsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    @Override
    public Route updateRoute(Long id, RouteRequest dto) {
        Route route = getRouteById(id);

        route.setName(dto.getName());
        route.setFare(dto.getFare());

        return routeRepsitory.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepsitory.deleteById(id);
    }


}

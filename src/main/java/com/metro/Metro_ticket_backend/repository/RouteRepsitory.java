package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepsitory extends JpaRepository<Route,Long> {

    List<Route> findByStartStation_StationId(Long stationId);

    List<Route> findByEndStation_StationId(Long stationId);
}

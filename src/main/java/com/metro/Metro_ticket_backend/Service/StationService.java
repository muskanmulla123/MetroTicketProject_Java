package com.metro.Metro_ticket_backend.Service;

import com.metro.Metro_ticket_backend.DTO.StationCreateRequest;
import com.metro.Metro_ticket_backend.entity.Station;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StationService {
     List<Station> getAllStations();

     Station getStationById(Long id);

     Station createStation(StationCreateRequest request);

     Station updateStation(Long id, StationCreateRequest request);

    void deleteStationById(Long id);
}

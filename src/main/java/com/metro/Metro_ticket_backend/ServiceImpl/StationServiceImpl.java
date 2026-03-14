package com.metro.Metro_ticket_backend.ServiceImpl;

import com.metro.Metro_ticket_backend.DTO.StationCreateRequest;
import com.metro.Metro_ticket_backend.Service.StationService;
import com.metro.Metro_ticket_backend.entity.Station;
import com.metro.Metro_ticket_backend.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class StationServiceImpl implements StationService {


    private  final StationRepository stationRepository;

    @Override
    public  List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public  Station getStationById(Long id) {
        return stationRepository.findById(id).orElseThrow(()-> new RuntimeException("station not found"));
    }

    @Override
    public  Station createStation(StationCreateRequest request) {
        Station station=new Station();
        station.setName(request.getName());
        station.setAddress(request.getAddress());
        return stationRepository.save(station);

    }

    @Override
    public  Station updateStation(Long id, StationCreateRequest request) {

        Station station= getStationById(id);
        station.setName(request.getName());
        station.setAddress(request.getAddress());
        return stationRepository.save(station);

    }

    @Override
    public void deleteStationById(Long id) {
        stationRepository.deleteById(id);
    }


}

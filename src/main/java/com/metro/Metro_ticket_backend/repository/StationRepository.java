package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

    boolean existsByNameIgnoreCase(String name);
}

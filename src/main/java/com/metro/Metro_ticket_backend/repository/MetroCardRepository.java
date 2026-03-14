package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.MetroCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MetroCardRepository extends JpaRepository<MetroCard,Long> {
    Optional<MetroCard> findByUser_Id(Long userId);

    List<MetroCard> findByStatus(String status);
}

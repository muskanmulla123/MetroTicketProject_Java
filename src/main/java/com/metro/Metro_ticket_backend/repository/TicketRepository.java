package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findByUser_Id(Long userId);

    List<Ticket> findByUserEmail(String email);
}

package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query("SELECT p FROM Payment p WHERE p.ticket.id = :ticketId")
    Optional<Payment> findByTicketId(@Param("ticketId") Long ticketId);
}

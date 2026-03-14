package com.metro.Metro_ticket_backend.controller;

import com.metro.Metro_ticket_backend.DTO.TicketBookingRequest;
import com.metro.Metro_ticket_backend.DTO.TicketResponse;
import com.metro.Metro_ticket_backend.Service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;   // ✅ Correct import
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;   // ✅ must be final

    @PostMapping("/book")
    public ResponseEntity<TicketResponse> bookTicket(
            @RequestBody TicketBookingRequest request) {

        // temporary email for testing
        String email = "test@gmail.com";

        TicketResponse response = ticketService.bookTicket(request, email);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/my")
    public ResponseEntity<List<TicketResponse>> getMyTickets() {

        String email = "test@gmail.com"; // temporary

        return ResponseEntity.ok(ticketService.getMyTickets(email));
    }

     @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id)
    {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

}

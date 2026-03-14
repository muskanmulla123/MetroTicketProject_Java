package com.metro.Metro_ticket_backend.Service;

import com.metro.Metro_ticket_backend.DTO.TicketBookingRequest;
import com.metro.Metro_ticket_backend.DTO.TicketResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface TicketService {
    TicketResponse bookTicket(TicketBookingRequest request, String username);

    @Nullable List<TicketResponse> getMyTickets(String email);

    @Nullable TicketResponse getTicketById(Long id);


}

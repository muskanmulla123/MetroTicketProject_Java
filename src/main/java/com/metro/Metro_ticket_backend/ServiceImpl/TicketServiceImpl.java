package com.metro.Metro_ticket_backend.ServiceImpl;

import com.metro.Metro_ticket_backend.DTO.TicketBookingRequest;
import com.metro.Metro_ticket_backend.DTO.TicketResponse;
import com.metro.Metro_ticket_backend.Service.TicketService;
import com.metro.Metro_ticket_backend.entity.Station;
import com.metro.Metro_ticket_backend.entity.Ticket;
import com.metro.Metro_ticket_backend.entity.User;
import com.metro.Metro_ticket_backend.repository.StationRepository;
import com.metro.Metro_ticket_backend.repository.TicketRepository;
import com.metro.Metro_ticket_backend.repository.UserRepository;
import com.metro.Metro_ticket_backend.utill.QRCodeGenerator;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final StationRepository stationRepository;
    private final UserRepository userRepository;

    // =========================
    // Get Ticket By ID
    // =========================
    @Override
    public TicketResponse getTicketById(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        return new TicketResponse(
                ticket.getId(),
                ticket.getSourceStation(),
                ticket.getDestinationStation(),
                ticket.getFare(),
                ticket.getBookingTime(),
                ticket.getStatus(),
                ticket.getValidUntil()
        );
    }

    // =========================
    // Book Ticket
    // =========================
    @Override
    public TicketResponse bookTicket(TicketBookingRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Station source = stationRepository.findById(request.getSourceStationId())
                .orElseThrow(() -> new RuntimeException("Source station not found"));

        Station destination = stationRepository.findById(request.getDestinationStationId())
                .orElseThrow(() -> new RuntimeException("Destination station not found"));

        double fare = calculateFare(source.getStationId(), destination.getStationId());

        Ticket ticket = new Ticket();

        ticket.setUser(user);
        ticket.setSourceStation(source.getName());
        ticket.setDestinationStation(destination.getName());
        ticket.setFare(fare);
        ticket.setBookingTime(LocalDateTime.now());
        ticket.setStatus("BOOKED");
        ticket.setValidUntil(LocalDateTime.now().plusHours(2));

        Ticket savedTicket = ticketRepository.save(ticket);

        // Generate QR Code dynamically
        String qrCode = QRCodeGenerator.generateQRCode("TICKET-" + savedTicket.getId());

        TicketResponse response = new TicketResponse();
        response.setTicketId(savedTicket.getId());
        response.setSourceStation(savedTicket.getSourceStation());
        response.setDestinationStation(savedTicket.getDestinationStation());
        response.setFare(savedTicket.getFare());
        response.setBookingTime(savedTicket.getBookingTime());
        response.setStatus(savedTicket.getStatus());
        response.setValidUntil(savedTicket.getValidUntil());
        response.setQrCode(qrCode);

        return response;
    }

    // =========================
    // Get My Tickets
    // =========================
    @Override
    public List<TicketResponse> getMyTickets(String email) {

        List<Ticket> tickets = ticketRepository.findByUserEmail(email);

        return tickets.stream()
                .map(t -> new TicketResponse(
                        t.getId(),
                        t.getSourceStation(),
                        t.getDestinationStation(),
                        t.getFare(),
                        t.getBookingTime(),
                        t.getStatus(),
                        t.getValidUntil()
                ))
                .toList();
    }

    // =========================
    // Fare Calculation
    // =========================
    private double calculateFare(Long sourceId, Long destinationId) {

        int stations = Math.abs(destinationId.intValue() - sourceId.intValue());

        if (stations <= 3) {
            return 10.0;
        }
        else if (stations <= 6) {
            return 20.0;
        }
        else if (stations <= 10) {
            return 30.0;
        }
        else {
            return 40.0;
        }
    }

}
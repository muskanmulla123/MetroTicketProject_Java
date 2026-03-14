package com.metro.Metro_ticket_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class TicketResponse {
    public TicketResponse(Long ticketId,
                          String sourceStation,
                          String destinationStation,
                          double fare,
                          LocalDateTime bookingTime,
                          String status,
                          LocalDateTime validUntil) {

        this.ticketId = ticketId;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.fare = fare;
        this.bookingTime = bookingTime;
        this.status = status;
        this.validUntil = validUntil;
    }
    private Long ticketId;
    private String sourceStation;
    private String destinationStation;
    private double fare;
    private LocalDateTime bookingTime;
    private String status;
    private LocalDateTime validUntil;
    private String qrCode;

}

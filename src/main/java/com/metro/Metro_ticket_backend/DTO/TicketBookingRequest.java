package com.metro.Metro_ticket_backend.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingRequest {
    private Long sourceStationId;
    private Long destinationStationId;
}

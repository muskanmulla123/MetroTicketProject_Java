package com.metro.Metro_ticket_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistoryResponse {
    private Long ticketId;
    private String routeName;
    private double amount;
    private LocalDateTime bookedAt;
}

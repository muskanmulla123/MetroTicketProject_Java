package com.metro.Metro_ticket_backend.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private double amount;
    private String currency;
}

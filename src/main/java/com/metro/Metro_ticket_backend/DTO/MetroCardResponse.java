package com.metro.Metro_ticket_backend.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetroCardResponse {
    private Long cardId;
    private String cardType;
    private double balance;
    private String status;
}

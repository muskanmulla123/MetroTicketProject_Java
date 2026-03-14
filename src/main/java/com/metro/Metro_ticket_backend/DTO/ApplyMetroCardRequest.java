package com.metro.Metro_ticket_backend.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyMetroCardRequest {
    private String nameOnCard;
    private String cardType;
}

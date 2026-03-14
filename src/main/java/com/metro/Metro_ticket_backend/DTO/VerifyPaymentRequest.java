package com.metro.Metro_ticket_backend.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyPaymentRequest {
    private String orderId;
    private String paymentId;
    private String signature;
}

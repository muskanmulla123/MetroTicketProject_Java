package com.metro.Metro_ticket_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPaymentRequest {
    private Long ticketId;
    private double amount;
    private String currency;
    private String paymentStatus;
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
    private LocalDateTime paymentDate;
}

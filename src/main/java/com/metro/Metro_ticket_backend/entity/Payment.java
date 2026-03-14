package com.metro.Metro_ticket_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private double amount;

    private String currency;

    private String paymentStatus;

    private String razorpayOrderId;

    private String razorpayPaymentId;

    private String razorpaySignature;

    private LocalDateTime paymentDate;
}
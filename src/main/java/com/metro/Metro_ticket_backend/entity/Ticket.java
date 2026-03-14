package com.metro.Metro_ticket_backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceStation;

    private String destinationStation;

    private double fare;

    private LocalDateTime bookingTime;

    private String status;

    private LocalDateTime validUntil;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
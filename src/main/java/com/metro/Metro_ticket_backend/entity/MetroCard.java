package com.metro.Metro_ticket_backend.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metro_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetroCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String nameOnCard;

    private String cardType; // NORMAL / STUDENT / SENIOR

    private double balance;

    private String status; // PENDING / APPROVED / REJECTED
}
package com.metro.Metro_ticket_backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String message;

    private String reply;

    private LocalDateTime submittedAt;

    private LocalDateTime repliedAt;
}

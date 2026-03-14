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
public class ComplaintResponse {
    private Long complaintId;
    private String message;
    private String reply;
    private LocalDateTime submittedAt;
    private LocalDateTime repliedAt;
}

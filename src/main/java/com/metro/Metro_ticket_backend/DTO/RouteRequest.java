package com.metro.Metro_ticket_backend.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    private String name;
    private Long startStationId;
    private Long endStationId;
    private double fare;

}

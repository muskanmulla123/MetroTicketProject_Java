package com.metro.Metro_ticket_backend.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private Long routeId;
    private String name;
    private String startStation;
    private String endStation;
}

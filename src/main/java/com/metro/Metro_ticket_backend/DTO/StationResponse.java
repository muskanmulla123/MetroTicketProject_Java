package com.metro.Metro_ticket_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationResponse {
    private Long StationId;
    private String name;
    private String address;
}

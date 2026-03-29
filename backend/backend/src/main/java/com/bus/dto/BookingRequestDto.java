package com.bus.dto;
import lombok.Data;

@Data
public class BookingRequestDto {
    private Long userId;
    private Long routeId;
    private int seatNumber;
}

package com.bus.controller;


import com.busbooking.dto.BookingRequestDTO;
import com.busbooking.model.Booking;
import com.busbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")

public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookSeat(@RequestBody BookingRequestDTO dto) {
        return bookingService.bookSeat(dto);
    }

    @PutMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getMyBookings(@PathVariable Long userId) {
        return bookingService.getMyBookings(userId);
    }

    @GetMapping("/seats/{routeId}")
    public List<Integer> getBookedSeats(@PathVariable Long routeId) {
        return bookingService.getBookedSeats(routeId);
    }
}

}

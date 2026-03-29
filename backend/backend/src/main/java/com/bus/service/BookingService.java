package com.bus.service;
import com.busbooking.dto.BookingRequestDTO;
import com.busbooking.model.*;
import com.busbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookSeat(BookingRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Route route = routeRepository.findById(dto.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found"));

        List<Booking> existing = bookingRepository.findByRouteId(dto.getRouteId());

        for (Booking b : existing) {
            if (b.getSeatNumber() == dto.getSeatNumber() &&
                    b.getStatus().equals("BOOKED")) {
                throw new RuntimeException("Seat already booked");
            }
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoute(route);
        booking.setSeatNumber(dto.getSeatNumber());
        booking.setStatus("BOOKED");
        booking.setBookedAt(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Integer> getBookedSeats(Long routeId) {
        List<Booking> bookings = bookingRepository.findByRouteId(routeId);
        List<Integer> seats = new ArrayList<>();

        for (Booking b : bookings) {
            if (b.getStatus().equals("BOOKED")) {
                seats.add(b.getSeatNumber());
            }
        }
        return seats;
    }
}

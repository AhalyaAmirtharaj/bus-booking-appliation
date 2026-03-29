package com.bus.service;


import com.bus.entity.Bus;
import com.bus.entity.Route;
import com.bus.repository.BusRepository;
import com.bus.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public List<Route> searchRoutes(String source, String destination, String date) {
        LocalDate travelDate = LocalDate.parse(date);
        return routeRepository.findBySourceAndDestinationAndTravelDate(
                source, destination, travelDate
        );
    }

    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }


}

package com.bus.repository;

import com.bus.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    List<Route> findBySourceAndDestinationAndTravelDate(
            String source, String destination, LocalDate travelDate);



}

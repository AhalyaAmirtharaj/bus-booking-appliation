package com.bus.controller;


import com.bus.entity.Bus;
import com.bus.entity.Route;
import com.busbooking.model.*;
import com.busbooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/buses")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/routes/search")
    public List<Route> searchRoutes(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {

        return busService.searchRoutes(source, destination, date);
    }

    @PostMapping("/buses")
    public Bus addBus(@RequestBody Bus bus) {
        return busService.addBus(bus);
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route route) {
        return busService.addRoute(route);
    }
}


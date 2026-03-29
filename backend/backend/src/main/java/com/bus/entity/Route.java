package com.bus.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    private String source;
    private String destination;
    private LocalDate travelDate;
    private String departureTime;
    private double price;

}

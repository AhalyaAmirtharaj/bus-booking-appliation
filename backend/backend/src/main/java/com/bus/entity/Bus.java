package com.bus.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="buses")


public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busNumber;
    private String operator;
    private String busType;
    private int totalSeats;

}

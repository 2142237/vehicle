package com.vehicle.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String registrationNumber;
    private String model;
    @Column(name="style")
    private String style;

    @ManyToOne
    @JoinColumn(name ="fleet_id")
    private Fleet fleet;



}

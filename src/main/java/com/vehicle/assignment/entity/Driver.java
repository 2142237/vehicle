package com.vehicle.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder

//@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;
    private String address;
    @Column(name="license_number")
    private String licenseNumber;
    @Column(name="phone_number")
    private String phoneNumber;


}

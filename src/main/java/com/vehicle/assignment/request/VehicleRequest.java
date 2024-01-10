package com.vehicle.assignment.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {



    @Id
    private long id;

    private String registrationNumber;
    private String model;
    private String route;

    private String style;




}

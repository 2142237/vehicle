package com.vehicle.assignment.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName ="build")
@NoArgsConstructor
public class DriverRequest {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    private String licenseNumber;
    private String phoneNumber;

}
package com.vehicle.assignment.response;

import com.vehicle.assignment.entity.Driver;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DriverResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;
    private String address;
    private String license_number;
    private String phone_number;

    public DriverResponse(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.address = driver.getAddress();
        this.license_number = driver.getLicenseNumber();
        this.phone_number = driver.getPhoneNumber();
    }
}

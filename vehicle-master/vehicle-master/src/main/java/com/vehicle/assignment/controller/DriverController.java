package com.vehicle.assignment.controller;

import com.vehicle.assignment.entity.Driver;
import com.vehicle.assignment.exception.DriverNotFoundException;
import com.vehicle.assignment.exception.GeneralizedException;
import com.vehicle.assignment.request.DriverRequest;
import com.vehicle.assignment.service.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverServices driverServices;

    @PostMapping("/")
    public ResponseEntity<Driver> saveDriver(@RequestBody DriverRequest driverRequest) throws GeneralizedException{
        return new ResponseEntity<>(driverServices.addDriver(driverRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> findById(@PathVariable("id") long id) throws DriverNotFoundException {
        return ResponseEntity.ok(driverServices.findDriverById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Driver>> allDrivers() {
        return ResponseEntity.ok(driverServices.findAllDrivers());
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") long id) {
        driverServices.deleteDiverByID(id);
    }

    @PutMapping("/")
    public ResponseEntity<Driver> update(@RequestBody DriverRequest driverRequest) {
        return ResponseEntity.ok(driverServices.updateDriver(driverRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateById(@PathVariable("id") long id,
                                                 @RequestBody DriverRequest driverRequest){
        return ResponseEntity.ok(driverServices.updateDriverById(id,driverRequest));
    }
}
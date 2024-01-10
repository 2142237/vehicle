package com.vehicle.assignment.controller;

import com.vehicle.assignment.entity.Vehicle;
import com.vehicle.assignment.request.VehicleRequest;
import com.vehicle.assignment.service.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleServices vehicleServices;
    @PostMapping("/")
    public Vehicle addVehicle(@RequestBody VehicleRequest vehicleRequest){
        Vehicle add=vehicleServices.addVehicle(vehicleRequest);
        return add;
    }
    @GetMapping("/{id}")
    public Vehicle vehicleById(@PathVariable("id") long id){
        Vehicle ById=vehicleServices.findByID(id);
        return ById;

    }
    @GetMapping("/")
    public List<Vehicle> allVehicles(){
        List<Vehicle> Vehicles=vehicleServices.findAllVehicle();
        return Vehicles;
    }
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") long id){
        vehicleServices.deleteVehicleByID(id);
    }
    @PutMapping("/")
    public Vehicle update(@RequestBody VehicleRequest vehicleRequest){
        return vehicleServices.updateVehicle(vehicleRequest);
    }
    @GetMapping("/fleet/{id}")
    public List<Vehicle> getVehiclesByFleet(@PathVariable("id") long id){
        return vehicleServices.getVehiclesByFleet(id);
    }



}

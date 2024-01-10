package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Vehicle;
import com.vehicle.assignment.request.VehicleRequest;

import java.util.List;

public interface VehicleServices {

    public List<Vehicle> findAllVehicle();
    public Vehicle findByID(long id);
    public Vehicle addVehicle(VehicleRequest vehicleRequest);
    public void deleteVehicleByID(long id);
    public Vehicle updateVehicle(VehicleRequest vehicleRequest);
    List<Vehicle> getVehiclesByFleet(long id);

}

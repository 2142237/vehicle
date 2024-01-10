package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Fleet;
import com.vehicle.assignment.entity.Vehicle;
import com.vehicle.assignment.repository.FleetRepository;
import com.vehicle.assignment.repository.VehicleRepository;
import com.vehicle.assignment.request.VehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesServicesImpl implements VehicleServices {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private FleetRepository fleetRepository;

    @Override
    public List<Vehicle> findAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findByID(long id) {
        return vehicleRepository.findById(id).get();
    }


    public Vehicle addVehicle(VehicleRequest vehicleRequest) {
        String route = vehicleRequest.getRoute();
        Fleet fleet = fleetRepository.findByRoute(route).orElse(null);
        if(fleet == null) {
            fleet = new Fleet();
            fleet.setRoute(route);
            fleet.setCount(1);

        } else {
            fleet.setCount(fleet.getCount() + 1);

        }
        fleet = fleetRepository.save(fleet);

        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleRequest.getModel());
        vehicle.setStyle(vehicleRequest.getStyle());
        vehicle.setRegistrationNumber(vehicleRequest.getRegistrationNumber());
        vehicle.setFleet(fleet);

        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicleByID(long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle updateVehicle(VehicleRequest vehicleRequest) {

        Long  vehicleId=vehicleRequest.getId();
        Vehicle existingVehicle=vehicleRepository.findById(vehicleId).get();
        existingVehicle.setModel(vehicleRequest.getModel());
        existingVehicle.setStyle(vehicleRequest.getStyle());
        existingVehicle.setRegistrationNumber(vehicleRequest.getRegistrationNumber());
        return vehicleRepository.save(existingVehicle);
    }
        /*Long vehicleId = vehicleRequest.getId();
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if (existingVehicle != null) {
            existingVehicle.setModel(vehicleRequest.getModel());
            existingVehicle.setStyle(vehicleRequest.getStyle());
            existingVehicle.setRegistrationNumber(vehicleRequest.getRegistrationNumber());

            // Save the updated Vehicle
            return vehicleRepository.save(existingVehicle);
        }

        return null; // Handle case when the vehicle is not found*/


    @Override
    public List<Vehicle> getVehiclesByFleet(long id) {
        return null;
    }
}
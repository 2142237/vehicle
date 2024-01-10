package com.vehicle.assignment.repository;

import com.vehicle.assignment.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
       //List<Vehicle> findByFleetId(long fleeetId);
public Vehicle findByRegistrationNumber(String registrationNumber);


}

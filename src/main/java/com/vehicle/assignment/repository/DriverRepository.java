package com.vehicle.assignment.repository;

import com.vehicle.assignment.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByLicenseNumber(String licensenumber);

}

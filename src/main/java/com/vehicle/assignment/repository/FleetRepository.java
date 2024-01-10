package com.vehicle.assignment.repository;

import com.vehicle.assignment.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FleetRepository extends JpaRepository<Fleet,Long> {

    Optional<Fleet> findByRoute(String route);
}

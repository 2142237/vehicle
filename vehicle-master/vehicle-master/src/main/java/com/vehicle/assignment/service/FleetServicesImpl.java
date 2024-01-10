package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Fleet;
import com.vehicle.assignment.repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FleetServicesImpl implements FleetServices{
    @Autowired
     private FleetRepository fleetRepository;
    @Override
    public Fleet addFleet(Fleet fleet) {
        return fleetRepository.save(fleet);
    }

    @Override
    public List<Fleet> getAllFleets() {
        return fleetRepository.findAll();
    }

    @Override
    public void deleteFleetById(long id) {
        fleetRepository.deleteById(id);

    }

    @Override
    public Fleet getFleetByID(long id) {
        return null;
    }


}

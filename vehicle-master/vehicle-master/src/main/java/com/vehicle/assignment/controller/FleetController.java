package com.vehicle.assignment.controller;

import com.vehicle.assignment.entity.Fleet;
import com.vehicle.assignment.service.FleetServices;
import com.vehicle.assignment.service.FleetServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fleet")
public class FleetController {
    @Autowired
    private FleetServices fleetServices;
    @PostMapping("/")
    public Fleet addFleet(@RequestBody Fleet fleet){
       Fleet addFleet= fleetServices.addFleet(fleet);

        return addFleet;
    }
    @GetMapping("/")
    public List<Fleet> getFleet(){
        return fleetServices.getAllFleets();
    }
    @DeleteMapping("/{id}")
    public void deleteFleet(@PathVariable("id") long id){
        fleetServices.deleteFleetById(id);
    }

}

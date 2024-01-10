package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Fleet;

import java.util.List;

public interface FleetServices {
     public Fleet addFleet(Fleet fleet);
    public List<Fleet> getAllFleets();
    public void deleteFleetById(long id);
   // public Fleet getFleetByID(long id);

}

package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Driver;
import com.vehicle.assignment.exception.GeneralizedException;
import com.vehicle.assignment.request.DriverRequest;

import java.security.GeneralSecurityException;
import java.util.List;

public interface DriverServices {
    public Driver addDriver(DriverRequest driverRequest) throws GeneralizedException;
    public List<Driver> findAllDrivers();
    public Driver findDriverById(long id);
    public void deleteDiverByID(long id);
    public Driver updateDriver(DriverRequest driverRequest);

    public Driver updateDriverById(long id,DriverRequest driverRequest);


}

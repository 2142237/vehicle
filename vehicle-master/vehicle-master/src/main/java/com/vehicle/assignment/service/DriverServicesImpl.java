package com.vehicle.assignment.service;

import com.vehicle.assignment.entity.Driver;
import com.vehicle.assignment.exception.DriverNotFoundException;
import com.vehicle.assignment.exception.ErrorCode;
import com.vehicle.assignment.exception.GeneralizedException;
import com.vehicle.assignment.repository.DriverRepository;
import com.vehicle.assignment.request.DriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServicesImpl implements DriverServices {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver addDriver(DriverRequest driverRequest) throws GeneralizedException {
        //Driver driver = Driver.build(0, driverRequest.getName(), driverRequest.getAddress(),
               // driverRequest.getLicense_number(), driverRequest.getPhone_number());
        Optional<Driver> saveDriver=driverRepository.findByLicenseNumber(driverRequest.getLicenseNumber());
        if(saveDriver.isPresent()){
            throw new GeneralizedException("already exist licenseNumber"+ErrorCode.DUPLICATE_LICENSE_NUMBER.getDescription(),
            ErrorCode.DUPLICATE_LICENSE_NUMBER, HttpStatus.BAD_REQUEST);
        }
        Driver driver=Driver.builder().name(driverRequest.getName())
                .address(driverRequest.getAddress())
                .licenseNumber(driverRequest.getLicenseNumber())
                .phoneNumber(driverRequest.getPhoneNumber()).build();
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> findAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();

        if (drivers.isEmpty()) {
            throw new DriverNotFoundException("No drivers found");
        }

        return drivers;
    }

    @Override
    public Driver findDriverById(long id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        //
        return optionalDriver.orElseThrow(() -> new DriverNotFoundException("Driver is not found with id : " + id));
    }

    @Override
    public void deleteDiverByID(long id) {
       Optional< Driver> driver = driverRepository.findById(id);
       if(driver.isPresent()){
           driverRepository.deleteById(id);

       }else{
           throw new DriverNotFoundException("Driver is not found with id:"+id);
       }
    }

    @Override
    public Driver updateDriver(DriverRequest driverRequest) {
        Long driverId = driverRequest.getId();
        Driver existingDriver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException("Driver is not found with id : " + driverId));

        existingDriver.setName(driverRequest.getName());
        existingDriver.setAddress(driverRequest.getAddress());
        existingDriver.setPhoneNumber(driverRequest.getPhoneNumber());
        existingDriver.setLicenseNumber(driverRequest.getPhoneNumber());

        // Save the updated driver
        return driverRepository.save(existingDriver);
    }

    @Override
    public Driver updateDriverById(long id, DriverRequest driverRequest) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver is not found with id : " + id));

        existingDriver.setName(driverRequest.getName());
        existingDriver.setAddress(driverRequest.getAddress());
        existingDriver.setPhoneNumber(driverRequest.getPhoneNumber());
        existingDriver.setLicenseNumber(driverRequest.getLicenseNumber());

        // Save the updated driver
        return driverRepository.save(existingDriver);
    }
}
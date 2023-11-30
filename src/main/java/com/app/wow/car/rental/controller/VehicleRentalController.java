package com.app.wow.car.rental.controller;


import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.service.VehicleRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleRentalController {
    @Autowired
    VehicleRentalService vehicleRentalService;

    @PostMapping(path = "/api/vehicleRegistration")
    public ResponseEntity<Void> findCustomerById(@RequestBody VehicleRental vehicleRental){
        try {
            vehicleRentalService.addvehiclerental(vehicleRental);
            return ResponseEntity.ok().build(); // Return a 200 OK response without a body
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }
}

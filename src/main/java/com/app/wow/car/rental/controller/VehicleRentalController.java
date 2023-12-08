package com.app.wow.car.rental.controller;


import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Office;
import com.app.wow.car.rental.model.Vehicle;
import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.service.VehicleRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleRentalController {
    @Autowired
    VehicleRentalService vehicleRentalService;

    @CrossOrigin
    @PostMapping(path = "/api/vehicleRegistration")
    public ResponseEntity<Void> addVehicleRegistration(@RequestBody VehicleRental vehicleRental){
        try {
            vehicleRentalService.addvehiclerental(vehicleRental);
            return ResponseEntity.ok().build(); // Return a 200 OK response without a body
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

    @CrossOrigin
    @PostMapping(path = "/api/update/vehicleRegistration")
    public ResponseEntity<Void> udpdateVehicleRegistration(@RequestBody VehicleRental vehicleRental){
        try {
            Boolean valid=true;
            if(vehicleRental.disid!=null)
                valid=vehicleRentalService.validateDiscountId(vehicleRental.disid);

            if(!valid)
                throw new Exception("Invalid discount");

            vehicleRentalService.updatevehiclerental(vehicleRental);
            return ResponseEntity.ok().build(); // Return a 200 OK response without a body
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

    @GetMapping(path = "/api/vehicleRegistration/{id}")
    public ResponseEntity<VehicleRental> getVehicleRegistration(@PathVariable("id") Long id){
        try{
            VehicleRental vehicleRental=vehicleRentalService.getVehicleRegistrationById(id);
            if(vehicleRental!=null){
                return new ResponseEntity<>(vehicleRental, HttpStatus.OK);
            }
            else
                throw new Exception("internal service error");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

    @GetMapping(path = "/api/vehicle/list/{pickupId}")
    public ResponseEntity<List<Vehicle>> getVehicleList(@PathVariable("pickupId") Integer pickupId){
        try{
            List<Vehicle> vehicleList=vehicleRentalService.getVehicleList(pickupId);
            if(!vehicleList.isEmpty()){
                return new ResponseEntity<>(vehicleList, HttpStatus.OK);
            }
            else
                throw new Exception("Enter correct pickup location");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

    @GetMapping(path = "/api/office/list")
    public ResponseEntity<List<Office>> getOfficeList(){
        try{
            List<Office> officeList=vehicleRentalService.getOfficeList();
            if(!officeList.isEmpty()){
                return new ResponseEntity<>(officeList, HttpStatus.OK);
            }
            else
                throw new Exception("Internal Service Error");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

    @GetMapping(path = "/api/vehicleService/list/{custId}")
    public ResponseEntity<List<VehicleRental>> getVehicleServiceList(@PathVariable("custId") Long custId){
        try{
            List<VehicleRental> vehicleServiceList=vehicleRentalService.getVehicleServiceList(custId);
            if(vehicleServiceList!=null){
                return new ResponseEntity<>(vehicleServiceList, HttpStatus.OK);
            }
            else
                throw new Exception("Internal service error");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }

}

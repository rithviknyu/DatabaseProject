package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.model.VehicleRentalE;
import com.app.wow.car.rental.service.VehicleRentalEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleRentalEController {

    @Autowired
    VehicleRentalEService vehicleRentalEService;
    @GetMapping(path = "/api/vehicleEService/list")
    public ResponseEntity<List<VehicleRentalE>> getVehicleServiceEList(){
        try{
            List<VehicleRentalE> vehicleServiceList=vehicleRentalEService.getVehicleServiceEList();
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

    @DeleteMapping(path = "/api/vehicleEService/delete/{serviceId}")
    public ResponseEntity<Void> deleteVehicleServiceE(@PathVariable Long serviceId){
        try{
            vehicleRentalEService.deleteVehicleServiceE(serviceId);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }
}

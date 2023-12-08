package com.app.wow.car.rental.controller;
import com.app.wow.car.rental.dto.RegistrationRequest;
import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.IndividualCustomer;
import com.app.wow.car.rental.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {


    @Autowired RegistrationService registrationService;


    @PostMapping("/api/registration/individual")
    public ResponseEntity<String> registerIndividualCustomer(@RequestBody RegistrationRequest request) {

        try {
            if(registrationService.registerCustomer(request)) {
                return ResponseEntity.ok("Customer registered successfully");
            }else {
                return ResponseEntity.badRequest().body("Registration Failed");
            }
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }

    }


    @PostMapping("/api/registration/corporate")
    public ResponseEntity<String> registerCorpCustomer(@RequestBody RegistrationRequest request) {

        try {
            if(registrationService.registerCustomer(request)) {
                return ResponseEntity.ok("Customer registered successfully");
            }else {
                return ResponseEntity.badRequest().body("Registration Failed");
            }
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }

    }

}

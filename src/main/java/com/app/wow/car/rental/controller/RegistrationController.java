package com.app.wow.car.rental.controller;
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
    public ResponseEntity<String> registerIndividualCustomer(@RequestBody IndividualCustomer customer) {

        try {
            registrationService.registerCustomer(customer);
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }

    }


    @PostMapping("/api/registration/corporate")
    public ResponseEntity<String> registerCorpCustomer(@RequestBody CorporateCustomer customer) {

        try {
            registrationService.registerCustomer(customer);
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }

    }

}

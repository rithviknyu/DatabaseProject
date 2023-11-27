package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/api/customer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}

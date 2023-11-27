package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(Long id){
        return customerRepository.getCustomerById(id);
    }
}

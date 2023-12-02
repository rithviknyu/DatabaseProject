package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.IndividualCustomer;
import com.app.wow.car.rental.repository.CorporateCustomerRepository;
import com.app.wow.car.rental.repository.IndividualCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final IndividualCustomerRepository individualCustomerRepository;

    @Autowired
    public RegistrationService(CorporateCustomerRepository corporateCustomerRepository,
                               IndividualCustomerRepository individualCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
        this.individualCustomerRepository = individualCustomerRepository;
    }

    @Transactional
    public void registerCustomer(Customer customer) {
        // Check the type of customer and cast to the appropriate class
        if (customer instanceof CorporateCustomer) {
            System.out.println("Saving corporate customer.");
            CorporateCustomer corporateCustomer = (CorporateCustomer) customer;
            corporateCustomerRepository.save(corporateCustomer);
        } else if (customer instanceof IndividualCustomer) {
            System.out.println("Saving individual customer.");
            IndividualCustomer individualCustomer = (IndividualCustomer) customer;
            individualCustomerRepository.save(individualCustomer);
        } else {
            System.out.println("not Saving any customer.");
        }
    }
}

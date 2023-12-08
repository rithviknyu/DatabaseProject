package com.app.wow.car.rental.service;

import com.app.wow.car.rental.dto.RegistrationRequest;
import com.app.wow.car.rental.model.*;
import com.app.wow.car.rental.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class RegistrationService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final IndividualCustomerRepository individualCustomerRepository;

    private final PrsLoginRepository prsLoginRepository;

    private final PrsCustomerLoginTableRepository prsCustomerLoginTableRepository;

    private final CustomerRepository customerRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public RegistrationService(CorporateCustomerRepository corporateCustomerRepository,
                               IndividualCustomerRepository individualCustomerRepository,
                               PrsLoginRepository prsLoginRepository,
                               PrsCustomerLoginTableRepository prsCustomerLoginTableRepository,
                               CustomerRepository customerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
        this.individualCustomerRepository = individualCustomerRepository;
        this.prsLoginRepository = prsLoginRepository;
        this.prsCustomerLoginTableRepository = prsCustomerLoginTableRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public boolean registerCustomer(RegistrationRequest request) {

        try {
            ModelMapper modelMapper = new ModelMapper();

            Customer customer = null;
            if (isCorporateCustomer(request)) {
                CorporateCustomer corporateCustomer = modelMapper.map(request, CorporateCustomer.class);
                // Check the type of customer and cast to the appropriate class
                System.out.println("Saving corporate customer.");
                CorporateCustomer corpCust = corporateCustomerRepository.save(corporateCustomer);
                customer = customerRepository.findById(corpCust.getCustid()).get();

            } else {
                IndividualCustomer individualCustomer = modelMapper.map(request, IndividualCustomer.class);
                System.out.println("Saving individual customer.");
                IndividualCustomer indvCust = individualCustomerRepository.save(individualCustomer);
                customer = customerRepository.findById(indvCust.getCustid()).get();
            }

            PrsLogin prsLogin = new PrsLogin();
            prsLogin.setLoginType(PrsLogin.LoginType.CL);
            prsLogin.setUsername(request.getUsername());
            prsLogin.setPassword(passwordEncoder.encode(request.getPassword()));
            PrsLogin prsLogindb = prsLoginRepository.save(prsLogin);

            CustomerLogin customerLogin = new CustomerLogin();
            customerLogin.setPrsCustomer(customer);
            customerLogin.setUsername(request.getUsername());
           // customerLogin.setPrsLogin(prsLogindb);
            prsCustomerLoginTableRepository.save(customerLogin);


        }catch (Exception e){
            return false;
        }

        return true;
    }

    private boolean isCorporateCustomer(RegistrationRequest registrationRequest){
        return Objects.nonNull(registrationRequest.getEmpid()) && Objects.nonNull(registrationRequest.getRegisnum());
    }
}

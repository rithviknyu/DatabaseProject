package com.app.wow.car.rental.service;

import com.app.wow.car.rental.dto.RegistrationRequest;
import com.app.wow.car.rental.model.*;
import com.app.wow.car.rental.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
                int corpCust = corporateCustomerRepository.registerCorporateCustomer(corporateCustomer.getCustid(), corporateCustomer.getEmpid(),
                        corporateCustomer.getRegisnum(),corporateCustomer.getStreet(),
                        corporateCustomer.getCity(), corporateCustomer.getState(), corporateCustomer.getZipcode(), corporateCustomer.getPhoneno(),
                        corporateCustomer.getEmailid(),"C");
                customer = customerRepository.findById(corpCust).get();

            } else {
                IndividualCustomer individualCustomer = modelMapper.map(request, IndividualCustomer.class);
                System.out.println("Saving individual customer.");
                int custId = individualCustomerRepository.registerIndividualCustomer(0,
                        individualCustomer.getFname(), individualCustomer.getMname(), individualCustomer.getLname(), individualCustomer.getDrivingLicenseNumber(),
                        individualCustomer.getInsuranceName(), individualCustomer.getInsuranceNumber(), individualCustomer.getStreet(),
                        individualCustomer.getCity(), individualCustomer.getState(), individualCustomer.getZipcode(), individualCustomer.getPhoneno(),
                        individualCustomer.getEmailid(),"I");

                System.out.println("done");
                customer = customerRepository.findById(custId).get();
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
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean isCorporateCustomer(RegistrationRequest registrationRequest){
        return Objects.nonNull(registrationRequest.getEmpid()) && Objects.nonNull(registrationRequest.getRegisnum());
    }
}

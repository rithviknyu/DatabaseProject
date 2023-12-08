package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository  extends
        JpaRepository<IndividualCustomer, Long> {

}

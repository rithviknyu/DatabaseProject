package com.app.wow.car.rental.repository;
import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
public interface CorporateCustomerRepository extends
        JpaRepository<CorporateCustomer, Long> {

}

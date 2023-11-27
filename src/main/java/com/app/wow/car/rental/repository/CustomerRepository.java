package com.app.wow.car.rental.repository;


import com.app.wow.car.rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "CALL GET_CUST_BY_ID(:cust_id);", nativeQuery = true)
    Customer getCustomerById(@Param("cust_id") Long customerId);
}

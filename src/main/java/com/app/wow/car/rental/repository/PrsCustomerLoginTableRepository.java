package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrsCustomerLoginTableRepository extends JpaRepository<CustomerLogin, String> {
    @Query(value="select customer_id from prs_customerlogintable where username = ?1", nativeQuery = true)
    String findByUsername(String username);
}
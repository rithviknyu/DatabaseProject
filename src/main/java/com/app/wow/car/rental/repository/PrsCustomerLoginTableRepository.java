package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrsCustomerLoginTableRepository extends JpaRepository<CustomerLogin, String> {
}
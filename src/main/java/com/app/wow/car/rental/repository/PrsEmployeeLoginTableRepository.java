package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrsEmployeeLoginTableRepository extends JpaRepository<EmployeeLogin, String> {
}
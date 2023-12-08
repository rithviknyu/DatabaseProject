package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.PrsLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrsLoginRepository extends JpaRepository<PrsLogin, String> {

    PrsLogin findAllByUsernameAndLoginType(String username, PrsLogin.LoginType loginType);
}

package com.app.wow.car.rental.service;
import com.app.wow.car.rental.model.*;
import com.app.wow.car.rental.repository.PrsCustomerLoginTableRepository;
import com.app.wow.car.rental.repository.PrsEmployeeLoginTableRepository;
import com.app.wow.car.rental.repository.PrsLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    @Autowired
    private PrsLoginRepository prsLoginRepository;

    @Autowired
    private PrsCustomerLoginTableRepository customerLoginTableRepository;

    @Autowired
    private PrsEmployeeLoginTableRepository employeeLoginTableRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public String authenticateUser(String username, String rawPassword, PrsLogin.LoginType loginType) {
        String encryptedPassword = passwordEncoder.encode(rawPassword);

        PrsLogin prsLogin = prsLoginRepository.findAllByUsernameAndLoginType(username, loginType);

        String userId = customerLoginTableRepository.findByUsername(prsLogin.getUsername());
        System.out.println(userId);

        return userId;
    }
}

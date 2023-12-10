package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.dto.MessageResponse;
import com.app.wow.car.rental.dto.SignInRequest;
import com.app.wow.car.rental.model.PrsLogin;
import com.app.wow.car.rental.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<MessageResponse> authenticateUser(@RequestBody SignInRequest signInRequest) {
        String custId = loginService.authenticateUser(signInRequest.getUsername(), signInRequest.getPassword(), signInRequest.getLoginType());
        if(custId != null) {
            return ResponseEntity.ok(new MessageResponse(" Successfully logged in with CustID: "+custId));
        }else {
            return ResponseEntity.badRequest().body(new MessageResponse("Login Failed"));
        }
    }
}

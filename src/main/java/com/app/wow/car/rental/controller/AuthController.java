package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.dto.MessageResponse;
import com.app.wow.car.rental.dto.SignInRequest;
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

        if(loginService.authenticateUser(signInRequest.getUsername(), signInRequest.getPassword(), signInRequest.getLoginType())) {
            return ResponseEntity.ok(new MessageResponse("User Authenticated successfully!"));
        }else {
            return ResponseEntity.badRequest().body(new MessageResponse("Authentication Failed.!"));
        }
    }
}

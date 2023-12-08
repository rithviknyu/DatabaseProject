package com.app.wow.car.rental.dto;

import com.app.wow.car.rental.model.PrsLogin;
import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
    private PrsLogin.LoginType loginType;
}

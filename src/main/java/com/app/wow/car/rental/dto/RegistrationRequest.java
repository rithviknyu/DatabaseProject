package com.app.wow.car.rental.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistrationRequest {

    private Integer custid;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String phoneno;
    private String emailid;

    private String username;
    private String password;
    private  String fname;
    private  String mname;
    private String lname;
    private String drivingLicenseNumber;
    private String insuranceName;
    private String insuranceNumber;
    private String empid;
    private BigInteger regisnum;
}

package com.app.wow.car.rental.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "PRS_INDIVIDUAL2")
@DiscriminatorValue("I")
@Data
public class IndividualCustomer extends  Customer {

    private  String fname;
    private  String mname;
    private String lname;
    @Column(name = "dlicenseno")
    private String drivingLicenseNumber;
    @Column(name = "insname") private String insuranceName;
    @Column(name = "inspnum") private String insuranceNumber;

}

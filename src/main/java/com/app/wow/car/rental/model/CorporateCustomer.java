package com.app.wow.car.rental.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity(name = "PRS_CORPORATE2")
@DiscriminatorValue("C")
@Data
public class CorporateCustomer extends Customer {
    private BigInteger empid;
    private BigInteger regisnum;

}

package com.app.wow.car.rental.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prs_customerlogintable")
@Data
@IdClass(LoginIdClass.class)
public class CustomerLogin {


    @Id
    private String username;
  /*  @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private PrsLogin prsLogin;*/

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "custid")
    private Customer prsCustomer;

}

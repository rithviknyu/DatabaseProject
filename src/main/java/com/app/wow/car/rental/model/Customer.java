

package com.app.wow.car.rental.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "PRS_CUSTOMER2")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="custtype", discriminatorType = DiscriminatorType.STRING)
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custid;
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipcode;
    @Column
    private String phoneno;
    @Column
    private String emailid;


}




package com.app.wow.car.rental.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRS_CUSTOMER", schema = "wow")
@Data
public class Customer {
    @Id
    @Column(name = "custid")
    private Long custid;
    @Column(name = "street")
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
    @Column
    private String custtype;

}


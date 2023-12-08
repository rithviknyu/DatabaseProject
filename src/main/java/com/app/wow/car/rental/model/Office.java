package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRS_OFFICE_LOCATION", schema = "wow")
@Data
public class Office {

    @Id
    @Column(name="locationid")
    Integer locId;
    // change this to locId if its defined like that in ur db table

    @Column(name="street")
    String street;

    @Column(name="city")
    String city;

    @Column(name="state")
    String state;

    @Column(name="zipcode")
    String zipcode;

   String phoneno;
}

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
    @Column(name="locId")
    Integer locId;

    @Column(name="street")
    String street;

    @Column(name="city")
    String city;

    @Column(name="state")
    String state;

    @Column(name="zipcode")
    String zipcode;

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

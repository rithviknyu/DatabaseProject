package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRS_VEHICLE", schema = "wow")
@Data
public class Vehicle {

    @Column(name="make")
    String make;

    @Column(name="model")
    String model;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Id
    @Column(name="vin")
    String vin;

}

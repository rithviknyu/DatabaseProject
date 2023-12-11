package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prs_disindividual", schema = "wow")
@Data
public class IndividualDiscount extends Discount{
    @Column(name = "couponid")
    private String couponId;
}

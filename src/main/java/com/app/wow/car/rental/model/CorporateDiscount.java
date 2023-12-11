package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prs_discorporate", schema = "wow")
@Data
public class CorporateDiscount extends Discount{
    @Column(name = "regisnum")
    private Long regisNum;
}

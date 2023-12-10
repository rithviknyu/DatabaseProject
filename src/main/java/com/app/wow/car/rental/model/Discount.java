package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRS_DISCOUNT", schema = "wow")
@Data
public class Discount {

    @Id
    @Column(name="disid")
    Integer disid;

    @Column(name="distype")
    String distype;

    @Column(name="dpercent")
    BigDecimal dpercent;

    @Column(name="startdate")
    public LocalDateTime startdate;

    @Column(name="enddate")
    public LocalDateTime enddate;

    public void setDisid(Integer disid) {
        this.disid = disid;
    }

    public void setDistype(String distype) {
        this.distype = distype;
    }

    public void setDpercent(BigDecimal dpercent) {
        this.dpercent = dpercent;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }
}

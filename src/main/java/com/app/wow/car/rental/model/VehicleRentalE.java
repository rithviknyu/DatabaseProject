package com.app.wow.car.rental.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRS_RENTAL_SERVICE", schema = "wow")
@Data
public class VehicleRentalE {

    @Id
    @Column(name = "serviceid")
    public Long serviceid;
    @Column(name = "pickdate")
    public LocalDateTime pickdate;

    @Column(name = "custid")
    public Long custid;
    @Column(name = "vin")
    public String vin;

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    @Nullable
    @Column(name = "payStatus")
    public Boolean payStatus;

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }

    public void setPickdate(LocalDateTime pickdate) {
        this.pickdate = pickdate;
    }

    public void setCustid(Long custid) {
        this.custid = custid;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}

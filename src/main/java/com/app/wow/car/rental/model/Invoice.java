package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "PRS_INVOICE", schema = "wow")
@Data
public class Invoice {
    @Id
    @Column(name="invoiceId")
    Long invoiceId;

    @Column(name="serviceId")
    Long serviceId;

    @Column(name="amount")
    BigDecimal amt;

    @Column(name="payStatus")
    Boolean payStatus;

    public void setInvoiceId(Long custId) {
        this.invoiceId = custId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }
}

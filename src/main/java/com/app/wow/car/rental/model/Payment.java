package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRS_PMETHOD_INVOICE", schema = "wow")
@Data
public class Payment {

    @Id
    @Column(name = "methodid")
    public Long methodid;
    @Id
    @Column(name = "invoiceid")
    public Long invoiceid;
    @Column(name = "pcardnum")
    public String pcardnum;

}

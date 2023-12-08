package com.app.wow.car.rental.model;

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
public class VehicleRental {

        @Id
        @Column(name = "serviceid")
        public Long serviceid;
        @Column(name = "pickdate")
        public LocalDateTime pickdate;
        @Column(name = "dropdate")
        public LocalDateTime dropdate;
        @Column(name = "startodo")
        public BigDecimal startodo;
        @Column(name = "endodo")
        public BigDecimal endodo;
        @Column(name = "dlimit")
        public Long dlimit;
        @Column(name = "custid")
        public Long custid;
        @Column(name = "vin")
        public String vin;
        @Column(name = "pickuplocid")
        public Long pickuplocid;
        @Column(name = "dropofflocid")
        public Long dropofflocid;
        @Column(name = "disid")
        public Long disid;

        public void setServiceid(Long serviceid) {
                this.serviceid = serviceid;
        }

        public void setPickdate(LocalDateTime pickdate) {
                this.pickdate = pickdate;
        }

        public void setDropdate(LocalDateTime dropdate) {
                this.dropdate = dropdate;
        }

        public void setStartodo(BigDecimal startodo) {
                this.startodo = startodo;
        }

        public void setEndodo(BigDecimal endodo) {
                this.endodo = endodo;
        }

        public void setDlimit(Long dlimit) {
                this.dlimit = dlimit;
        }

        public void setCustid(Long custid) {
                this.custid = custid;
        }

        public void setVin(String vin) {
                this.vin = vin;
        }

        public void setPickuplocid(Long pickuplocid) {
                this.pickuplocid = pickuplocid;
        }

        public void setDropofflocid(Long dropofflocid) {
                this.dropofflocid = dropofflocid;
        }

        public void setDisid(Long disid) {
                this.disid = disid;
        }
}

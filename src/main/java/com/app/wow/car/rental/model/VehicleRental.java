package com.app.wow.car.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
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
        public Long startodo;
        @Column(name = "endodo")
        public Long endodo;
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

}

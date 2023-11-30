package com.app.wow.car.rental.repository;


import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.VehicleRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRentalRepository extends JpaRepository<VehicleRental, Long> {

    @Query(value = "CALL VehicleRentalRegistration(:service_id, :pick_date, :drop_date, :start_odo, :end_odo, :d_limit, :cust_id, :vin, :pickup_locid, :dropoff_locid, :dis_id);", nativeQuery = true)
    public void registerVehicleRental(
            @Param("service_id") Long serviceId,
            @Param("pick_date") String pickDate,
            @Param("drop_date") String dropDate,
            @Param("start_odo") Long startOdo,
            @Param("end_odo") Long endOdo,
            @Param("d_limit") Long dLimit,
            @Param("cust_id") Long custId,
            @Param("vin") String vin,
            @Param("pickup_locid") Long pickupLocId,
            @Param("dropoff_locid") Long dropoffLocId,
            @Param("dis_id") Long disId
    );

}

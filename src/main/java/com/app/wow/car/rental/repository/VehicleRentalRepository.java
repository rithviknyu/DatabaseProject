package com.app.wow.car.rental.repository;


import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Vehicle;
import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.model.VehicleStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public interface VehicleRentalRepository extends JpaRepository<VehicleRental, Long> {

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Query(value = "CALL VehicleRentalRegistration(:service_id, :pick_date, :drop_date, :start_odo, :end_odo, :d_limit, :cust_id, :vin, :pickup_locid, :dropoff_locid, :dis_id);", nativeQuery = true)
    public void registerVehicleRental(
            @Param("service_id") Long serviceId,
            @Param("pick_date") String pickDate,
            @Param("drop_date") String dropDate,
            @Param("start_odo") BigDecimal startOdo,
            @Param("end_odo") BigDecimal endOdo,
            @Param("d_limit") Long dLimit,
            @Param("cust_id") Long custId,
            @Param("vin") String vin,
            @Param("pickup_locid") Long pickupLocId,
            @Param("dropoff_locid") Long dropoffLocId,
            @Param("dis_id") Long disId
    );

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Query(value = "CALL VehicleRentalUpdate(:service_id, :pick_date, :drop_date, :start_odo, :end_odo, :d_limit, :cust_id, :vin, :pickup_locid, :dropoff_locid, :dis_id);", nativeQuery = true)
    public void updateVehicleRental(
            @Param("service_id") Long serviceId,
            @Param("pick_date") String pickDate,
            @Param("drop_date") String dropDate,
            @Param("start_odo") BigDecimal startOdo,
            @Param("end_odo") BigDecimal endOdo,
            @Param("d_limit") Long dLimit,
            @Param("cust_id") Long custId,
            @Param("vin") String vin,
            @Param("pickup_locid") Long pickupLocId,
            @Param("dropoff_locid") Long dropoffLocId,
            @Param("dis_id") Long disId
    );

    @Query(value = "CALL ValidateDiscount(:dis_id);", nativeQuery = true)
    Object validateDiscountId(@Param("dis_id") Long disId);

    @Query(value = "CALL GetVehicleRentalRegistrationById(:id);", nativeQuery = true)
    Object vehicleRentalById(@Param("id") Long customerId);

    @Query(value = "CALL GetVehicleList(:pickup_Id);", nativeQuery = true)
    Object[] getVehicleList(@Param("pickup_Id") Integer pickupId);

    @Query(value = "CALL GetOfficeList();", nativeQuery = true)
    Object[] getOfficeList();

    @Query(value = "CALL GetVehicleServiceList(:cust_Id);", nativeQuery = true)
    Object[] getVehicleServiceList(@Param("cust_Id") Long custId);

    @Query(value = "CALL GetVehicleStat();", nativeQuery = true)
    Object[] findVehicleStatsByModel();
}

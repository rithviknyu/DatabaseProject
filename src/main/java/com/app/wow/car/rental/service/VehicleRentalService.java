package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.repository.VehicleRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRentalService {

    @Autowired
    VehicleRentalRepository vehicleRentalRepository;

    public void addvehiclerental(VehicleRental vehicleRental) {
        vehicleRentalRepository.registerVehicleRental(
                vehicleRental.serviceid,
                (vehicleRental.pickdate != null) ? vehicleRental.pickdate.toString() : null,
                (vehicleRental.dropdate != null) ? vehicleRental.dropdate.toString() : null,
                vehicleRental.startodo,
                vehicleRental.endodo,
                vehicleRental.dlimit,
                vehicleRental.custid,
                vehicleRental.vin,
                vehicleRental.pickuplocid,
                vehicleRental.dropofflocid,
                vehicleRental.disid
        );
    }

    public VehicleRental getVehicleRegistrationById(Long id) {
        return vehicleRentalRepository.vehicleRentalById(id);
    }
}

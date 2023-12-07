package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Office;
import com.app.wow.car.rental.model.Vehicle;
import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.repository.VehicleRentalRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void updatevehiclerental(VehicleRental vehicleRental) {
        vehicleRentalRepository.updateVehicleRental(
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

    public Boolean validateDiscountId(Long disId) {
        if((Long)vehicleRentalRepository.validateDiscountId(disId) == 0)
                return false;
        return true;
    }

    public VehicleRental getVehicleRegistrationById(Long id) {
        return vehicleRentalRepository.vehicleRentalById(id);
    }

    public List<Vehicle> getVehicleList(Integer pickupId){
        Object[] list= vehicleRentalRepository.getVehicleList(pickupId);

        List<Vehicle> vehicleList=new ArrayList<>();
        for(Object obj: list){
            Object[] objList=(Object[])obj;
            Vehicle vehicle=new Vehicle();
            vehicle.setMake((String)objList[0]);
            vehicle.setModel((String)objList[1]);
            vehicle.setVin((String)objList[2]);

            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    public List<Office> getOfficeList(){
        Object[] list= vehicleRentalRepository.getOfficeList();

        List<Office> officeList=new ArrayList<>();
        for(Object obj: list){
            Object[] objList=(Object[])obj;
            Office office=new Office();
            office.setLocId((Integer)objList[0]);
            office.setStreet((String)objList[1]);
            office.setCity((String)objList[2]);
            office.setState((String)objList[3]);
            office.setZipcode((String)objList[4]);

            officeList.add(office);
        }
        return officeList;
    }
}

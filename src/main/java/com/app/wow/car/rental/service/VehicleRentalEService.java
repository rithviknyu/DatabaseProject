package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.VehicleRental;
import com.app.wow.car.rental.model.VehicleRentalE;
import com.app.wow.car.rental.repository.VehicleRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleRentalEService {

    @Autowired
    VehicleRentalRepository vehicleRentalRepository;

    public List<VehicleRentalE> getVehicleServiceEList(){
        Object[] list= vehicleRentalRepository.getVehicleServiceEList();
        List<VehicleRentalE> vehicleServiceList=new ArrayList<>();

        for(Object obj: list){
            Object[] objList=(Object[])obj;
            VehicleRentalE vehicle = new VehicleRentalE();

            if (objList[0] != null) vehicle.setCustid(Long.valueOf((Integer) objList[0]));
            if (objList[1] != null) vehicle.setServiceid((Long) objList[1]);

            if (objList[2] != null) vehicle.setPickdate(((Timestamp) objList[2]).toLocalDateTime());

            if (objList[3] != null) vehicle.setVin((String) objList[3]);

            if(objList[4]==null || (Long)objList[4]==0)
                vehicle.setPayStatus(false);
            else
                vehicle.setPayStatus(true);

            vehicleServiceList.add(vehicle);
        }
        return vehicleServiceList;
    }

    public void deleteVehicleServiceE(Long serviceId){
        vehicleRentalRepository.deleteVehicleServiceE(serviceId);
    }
}

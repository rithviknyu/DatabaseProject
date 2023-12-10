package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Discount;
import com.app.wow.car.rental.model.Office;
import com.app.wow.car.rental.model.Payment;
import com.app.wow.car.rental.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    public List<Discount> getDiscountList(){
        Object[] list=discountRepository.getDiscountList();
        
        List<Discount> disList=new ArrayList<>();
        for(Object obj: list){
            Object[] objList=(Object[])obj;
            Discount dis=new Discount();
            if (objList[0] != null) dis.setDisid((Integer) objList[0]);

            if (objList[1] != null) dis.setDpercent((BigDecimal) objList[1]);
            if (objList[2] != null) dis.setDistype((String) objList[2]);

            if (objList[3] != null) dis.setStartdate(((Timestamp) objList[3]).toLocalDateTime());
            if (objList[4] != null) dis.setEnddate(((Timestamp) objList[4]).toLocalDateTime());

            disList.add(dis);
        }
        return disList;
    }
}

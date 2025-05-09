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
        List<Discount> list=discountRepository.findAll();

        return list;
    }
}

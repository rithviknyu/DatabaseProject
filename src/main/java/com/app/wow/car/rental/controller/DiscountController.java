package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.model.Discount;
import com.app.wow.car.rental.model.Invoice;
import com.app.wow.car.rental.service.DiscountService;
import com.app.wow.car.rental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @GetMapping(path = "/api/discount")
    public ResponseEntity<List<Discount>> getDiscountList(){
        return new ResponseEntity<>(discountService.getDiscountList(), HttpStatus.OK);
    }

    @PostMapping(path = "/api/discount/delete/{disid}")
    public ResponseEntity<String> deleteDiscount(@PathVariable("disid")  int disid) {
        if (discountService.deleteDiscount(disid))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

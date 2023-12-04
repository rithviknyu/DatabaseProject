package com.app.wow.car.rental.controller;

import com.app.wow.car.rental.model.Payment;
import com.app.wow.car.rental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(path = "/api/payment")
    public ResponseEntity<Void> addPayment(@RequestBody Payment payment){
        try {
            paymentService.addPayment(payment);
            return ResponseEntity.ok().build(); // Return a 200 OK response without a body
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Return an appropriate error response - 500 Internal Server Error
        }
    }
}

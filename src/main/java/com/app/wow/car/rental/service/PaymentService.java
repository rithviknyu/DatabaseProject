package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Payment;
import com.app.wow.car.rental.repository.CustomerRepository;
import com.app.wow.car.rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void addPayment(Payment payment){
        paymentRepository.addpayment(payment.invoiceid, payment.methodid, payment.pcardnum);
    }
}

package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Invoice;
import com.app.wow.car.rental.model.Payment;
import com.app.wow.car.rental.repository.CustomerRepository;
import com.app.wow.car.rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void addPayment(Payment payment){
        paymentRepository.save(payment);
    }

    public Invoice getInvoiceById(Long serviceId){
        Optional<Payment> payment= paymentRepository.findByInvoiceid(serviceId);
        Invoice invoice = new Invoice();
        if(payment.isPresent()){
            Payment payment1 = payment.get();
            invoice.setInvoiceId(payment1.getInvoiceid());
            invoice.setServiceId(payment1.getMethodid());
            // Amount and status is pending
        }
        return invoice;
    }
}

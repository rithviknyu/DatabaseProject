package com.app.wow.car.rental.service;

import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Invoice;
import com.app.wow.car.rental.model.Payment;
import com.app.wow.car.rental.repository.CustomerRepository;
import com.app.wow.car.rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void addPayment(Payment payment){
        paymentRepository.addpayment(payment.invoiceid, payment.methodid, payment.pcardnum);
    }

    public Invoice getInvoiceById(Long serviceId){
        Object[] list=(Object[])paymentRepository.getInvoiceById(serviceId);
        Invoice invoice=new Invoice();
        if (list[0] != null) {
            invoice.setInvoiceId((Long) list[0]);
        }
        if (list[1] != null) {
            invoice.setServiceId((Long) list[1]);
        }
        if (list[2] != null) {
            invoice.setAmt((BigDecimal) list[2]);
        }
        if(list[3]==null || (Long)list[3]==0)
            invoice.setPayStatus(false);
        else
            invoice.setPayStatus(true);
        return invoice;
    }
}

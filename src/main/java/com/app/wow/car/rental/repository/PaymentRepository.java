package com.app.wow.car.rental.repository;


import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Invoice;
import com.app.wow.car.rental.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

     Optional<Payment> findByInvoiceid(Long invoiceid);


}

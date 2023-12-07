package com.app.wow.car.rental.repository;


import com.app.wow.car.rental.model.Customer;
import com.app.wow.car.rental.model.Invoice;
import com.app.wow.car.rental.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "CALL addPayment(:invoice_id, :method_id, :p_card_num);", nativeQuery = true)
    public void addpayment(
            @Param("invoice_id") Long invoiceId,
            @Param("method_id") Long methodId,
            @Param("p_card_num") String pCardNum
    );

    @Query(value = "CALL GetInvoiceById(:service_Id);", nativeQuery = true)
    public Object getInvoiceById(
            @Param("service_Id") Long serviceId
    );
}

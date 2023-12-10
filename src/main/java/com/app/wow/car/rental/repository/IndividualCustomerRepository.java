package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface IndividualCustomerRepository  extends
        JpaRepository<IndividualCustomer, Long> {

    @Query(value = "CALL IndividualCustomerRegistration(:cust_id, :f_name, :m_name, :l_name, :dlicense_no, :ins_name, :insp_num, :street_name, :city_name, :state_name, :zip_code, :phone_no, :email_id, :cust_type);", nativeQuery = true)
    public int registerIndividualCustomer(
            @Param("cust_id") Integer custId,
            @Param("f_name") String fname,
            @Param("m_name") String mname,
            @Param("l_name") String lname,
            @Param("dlicense_no") String dlicense_no,
            @Param("ins_name") String insname,
            @Param("insp_num") String inspnum,
            @Param("street_name") String street,
            @Param("city_name") String city,
            @Param("state_name") String state,
            @Param("zip_code") String zipcode,
            @Param("phone_no") String phoneno,
            @Param("email_id") String emailid,
            @Param("cust_type") String custtype
    );
}

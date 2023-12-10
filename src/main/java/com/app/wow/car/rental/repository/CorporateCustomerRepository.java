package com.app.wow.car.rental.repository;
import com.app.wow.car.rental.model.CorporateCustomer;
import com.app.wow.car.rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

public interface CorporateCustomerRepository extends
        JpaRepository<CorporateCustomer, Long> {

    @Query(value = "CALL CorporateCustomerRegistration(:cust_id, :emp_id, :regis_num, :street_name, :city_name, :state_name, :zip_code, :phone_no, :email_id, :cust_type);", nativeQuery = true)
    public int registerCorporateCustomer(
            @Param("cust_id") Integer custId,
            @Param("emp_id") BigInteger empid,
            @Param("regis_num") BigInteger regisnum,
            @Param("street_name") String street,
            @Param("city_name") String city,
            @Param("state_name") String state,
            @Param("zip_code") String zipcode,
            @Param("phone_no") String phoneno,
            @Param("email_id") String emailid,
            @Param("cust_type") String custtype
    );

}

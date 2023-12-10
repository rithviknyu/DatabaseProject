package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query(value = "CALL GetDiscountList();", nativeQuery = true)
    public Object[] getDiscountList();
}

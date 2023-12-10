package com.app.wow.car.rental.repository;

import com.app.wow.car.rental.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query(value = "CALL GetDiscountList();", nativeQuery = true)
    public Object[] getDiscountList();

    @Query(value = "CALL DeleteDiscount(:dis_id);", nativeQuery = true)
    public void deleteDiscount(
            @Param("dis_id") int disId
    );
}

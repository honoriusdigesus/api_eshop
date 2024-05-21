package io.github.eshop.data.repository;

import io.github.eshop.data.entity.Shipping_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ShippingAddressRepository extends JpaRepository<Shipping_Address, Integer> {
    @Query("SELECT sa FROM Shipping_Address sa JOIN sa.users u WHERE u.cc = :cc")
    Shipping_Address findShippingAddressesBy(@Param("cc") BigDecimal cc);

}


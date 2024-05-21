package io.github.eshop.data.repository;

import io.github.eshop.data.entity.Shipping_Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Shipping_Address, Integer> {
}

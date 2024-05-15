package io.github.eshop.data.repository;

import io.github.eshop.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   @Query("SELECT p FROM Product p WHERE p.category = ?1")
    Product findByProductName(String category);
}

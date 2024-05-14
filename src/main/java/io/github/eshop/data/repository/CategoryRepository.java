package io.github.eshop.data.repository;

import io.github.eshop.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query("SELECT c FROM Category c WHERE c.category = ?1")
    Category findByCategoryName(String category);

}

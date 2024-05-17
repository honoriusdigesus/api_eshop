package io.github.eshop.data.repository;

import io.github.eshop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.cc = ?1")
    User findUserByCC(BigDecimal cc);
}

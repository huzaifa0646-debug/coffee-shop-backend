package com.shop.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.project.Entitys.Customers;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers,Long>{

    Optional<Customers> findByName(String name);
    @Query("SELECT c FROM Customers c WHERE c.email=:email")
    Optional<Customers> findByEmailCustomQuery(@Param("email") String email);
    
}

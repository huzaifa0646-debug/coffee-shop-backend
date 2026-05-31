package com.shop.project.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
import java.util.Optional;
import com.shop.project.Entitys.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    Page<Orders> findByCustomerId(Long customerId, Pageable pageable);
    Optional<Orders> findByStatus(String status);
    Page<Orders> findByOrderDateBetween(java.time.LocalDate startDate, java.time.LocalDate endDate, Pageable pageable);

    
}

package com.shop.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.shop.project.Entitys.OrderItems;
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {
    Page<OrderItems> findByOrderId(Long orderId, Pageable pageable);
    Page<OrderItems> findByProductId(Long productId, Pageable pageable);
}

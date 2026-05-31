package com.shop.project.Repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.project.Entitys.Product;
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByName(String name, Pageable pageable);
}
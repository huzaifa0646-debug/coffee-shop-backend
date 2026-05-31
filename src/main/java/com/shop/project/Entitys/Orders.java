package com.shop.project.Entitys;

//port org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate=LocalDateTime.now();
    private Double totalAmount;
    private String status="Pending";
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customers customer;
    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItems;
    
}

package com.shop.project.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class OrderItems {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    @NotNull(message = "Price is mandatory")
    private Double price;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Orders order;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
}

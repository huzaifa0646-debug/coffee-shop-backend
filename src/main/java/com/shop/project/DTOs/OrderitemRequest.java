package com.shop.project.DTOs;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter
public class OrderitemRequest {
    @NotNull(message = "Order ID is mandatory")
    private Long orderId;
    @NotNull(message = "Product ID is mandatory")
    private Long productId;
    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;
    @NotNull(message = "Price is mandatory")
    private Double price;
}
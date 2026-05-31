package com.shop.project.DTOs;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderitemResponse {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
}

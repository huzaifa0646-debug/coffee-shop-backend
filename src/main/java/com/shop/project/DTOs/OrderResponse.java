package com.shop.project.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private Long customerId;
    private String orderDate;
    private Double totalAmount;
    private String status;
    
}

package com.shop.project.DTOs;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter
public class OrdersRequest {
    @NotNull(message = "Customer ID is mandatory")
    private Long customerId;
}

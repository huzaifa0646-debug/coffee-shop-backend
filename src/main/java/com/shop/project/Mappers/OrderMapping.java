package com.shop.project.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shop.project.Entitys.Orders;
import com.shop.project.DTOs.OrdersRequest;
import com.shop.project.DTOs.OrderResponse;
@Mapper(componentModel = "spring")
public interface OrderMapping {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    Orders toEntity(OrdersRequest request);
    @Mapping(target = "customerId", source = "customer.id")
    OrderResponse toResponse(Orders entity);
}

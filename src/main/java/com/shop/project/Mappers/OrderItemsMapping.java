package com.shop.project.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shop.project.Entitys.OrderItems;
import com.shop.project.DTOs.OrderitemRequest;
import com.shop.project.DTOs.OrderitemResponse;
@Mapper(componentModel = "spring")
public interface OrderItemsMapping {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderItems toEntity(OrderitemRequest request);
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    OrderitemResponse toResponse(OrderItems entity);
    
}

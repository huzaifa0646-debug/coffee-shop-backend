package com.shop.project.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shop.project.Entitys.Product;
import com.shop.project.DTOs.ProductRequest;
import com.shop.project.DTOs.ProductResponse;
@Mapper(componentModel= "spring")
public interface ProductMapping {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(target = "inStock", ignore = true)
    Product toEntity(ProductRequest request);
    ProductResponse toResponse(Product entity);
    
}

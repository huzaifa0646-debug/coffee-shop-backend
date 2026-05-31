package com.shop.project.Mappers;

import org.mapstruct.Mapper;
import com.shop.project.Entitys.Customers;
import com.shop.project.DTOs.CustomersRequest;
import com.shop.project.DTOs.CustomersResponse;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CustomerMapping{
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Customers toEntity(CustomersRequest request);
    CustomersResponse toResponse(Customers entity);

}

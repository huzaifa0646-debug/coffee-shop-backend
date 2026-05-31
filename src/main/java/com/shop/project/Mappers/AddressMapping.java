package com.shop.project.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.shop.project.Entitys.Addresses;
import com.shop.project.DTOs.AddressRequest;
import com.shop.project.DTOs.AddressResponse;
@Mapper(componentModel = "spring")
public interface AddressMapping {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Addresses toEntity(AddressRequest request);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    AddressResponse toResponse(Addresses address);
    
}

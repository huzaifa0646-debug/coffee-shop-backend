package com.shop.project.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.project.Entitys.Addresses;
import com.shop.project.DTOs.AddressResponse;
import com.shop.project.Mappers.AddressMapping;
import com.shop.project.Repositories.AddressRepository;
import com.shop.project.DTOs.AddressRequest;
@Service
public class AddressService {
    private final AddressMapping addressMapping;
    private final AddressRepository addressRepository;
    public AddressService(AddressMapping addressMapping, AddressRepository addressRepository) {
        this.addressMapping = addressMapping;
        this.addressRepository = addressRepository;
    }
    @Transactional(readOnly = true)
    public AddressResponse getAddressByStreet(String street){
        Addresses address=addressRepository.findByStreet(street).orElseThrow(()->new RuntimeException("Street not found"));
        return addressMapping.toResponse(address);
    }
    @Transactional
    public AddressResponse createAddress(AddressRequest request){
        Addresses address=addressMapping.toEntity(request);
        Addresses savedaddress=addressRepository.save(address);
        return addressMapping.toResponse(savedaddress);
    }
    @Transactional
    public void deleteAddress(Long id){
        Addresses address=addressRepository.findById(id).orElseThrow(()->new RuntimeException("Address not found"));
        addressRepository.delete(address);
    }
    
}

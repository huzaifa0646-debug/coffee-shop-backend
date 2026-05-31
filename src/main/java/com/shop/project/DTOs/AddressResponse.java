package com.shop.project.DTOs;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressResponse {
    private Long id;
    private Long customerId;
    private String street;
    private String city;
    private String state;
}

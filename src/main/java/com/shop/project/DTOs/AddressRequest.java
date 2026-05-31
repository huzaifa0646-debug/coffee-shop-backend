package com.shop.project.DTOs;
//import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressRequest {
    @NotNull(message = "Customer ID is mandatory")
    private Long customerId;
    @NotBlank(message = "Street is mandatory")
    private String street;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "State is mandatory")
    private String state;
    
}

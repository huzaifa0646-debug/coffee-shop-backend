package com.shop.project.DTOs;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Getter
@Setter
public class CustomersRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Role is mandatory")
    private String role;
    @Email(message = "Email should be valid")
    private String email;
    }

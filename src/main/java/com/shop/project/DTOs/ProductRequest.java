package com.shop.project.DTOs;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter

public class ProductRequest {

    @NotBlank(message = "Product name is mandatory")
    private String name;

    @NotBlank(message = "Product description is mandatory")
    private String description;

    @NotNull(message = "Product price is mandatory")
    private Double price;

}
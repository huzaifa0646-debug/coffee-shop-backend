package com.shop.project.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotBlank(message = "Product description is mandatory")
    private String description;
    @NotNull(message = "Product price is mandatory")
    private Double price;
    @NotNull(message = "Product stock is mandatory")
    private Boolean inStock=true;
    @OneToMany(mappedBy = "product")
    private List<OrderItems> orderItems;
    
}

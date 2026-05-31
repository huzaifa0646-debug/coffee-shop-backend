package com.shop.project.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Addresses {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Street is mandatory")
    private String street;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "State is mandatory")
    private String state;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customers customer;
    
}

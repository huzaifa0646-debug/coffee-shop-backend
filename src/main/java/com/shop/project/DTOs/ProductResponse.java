package com.shop.project.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
private Long id;
private String name;
private String description;
private Double price;
}

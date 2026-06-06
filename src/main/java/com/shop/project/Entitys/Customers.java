package com.shop.project.Entitys;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Password is mandatory")
    private String password;
    // @NotBlank(message = "Roles are mandatory")
    // private String roles;
    @Email(message = "Email should be valid")
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Addresses> addresses;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    
}

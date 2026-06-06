package com.shop.project.Controllers;

import com.shop.project.DTOs.CustomersRequest;
import com.shop.project.Entitys.Customers;
import com.shop.project.Repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController // REQUIRED: Tells Spring this is a controller
@RequestMapping("/api")
public class AuthController {
    
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; // INJECT THIS

    // Constructor injection is best practice
    public AuthController(CustomerRepository customerRepository, 
                          PasswordEncoder passwordEncoder, 
                          AuthenticationManager authenticationManager) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CustomersRequest request) {
        Customers customers = new Customers();
        customers.setName(request.getName());
        customers.setPassword(passwordEncoder.encode(request.getPassword()));
        
        customerRepository.save(customers);
        return ResponseEntity.ok("User saved");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomersRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword())
            );

            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok("Welcome back, " + request.getName());
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        return ResponseEntity.status(401).body("Login failed");
    }
}
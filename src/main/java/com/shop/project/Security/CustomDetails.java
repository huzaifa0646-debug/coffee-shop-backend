package com.shop.project.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.project.Entitys.Customers;
import com.shop.project.Repositories.CustomerRepository;

@Service
public class CustomDetails implements UserDetailsService {
    
    private final CustomerRepository customerRepository;

    public CustomDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Fetch from repository
        Customers customer = customerRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found: " + username));

        // 2. Build the UserDetails object using the Spring User builder
        return User.builder()
                .username(customer.getName())
                .password(customer.getPassword())
                .roles("USER") // You can add logic to fetch actual roles here
                .build();
    }
}
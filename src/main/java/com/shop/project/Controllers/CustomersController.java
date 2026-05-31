package com.shop.project.Controllers;
import com.shop.project.DTOs.CustomersResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.project.Service.CustomerService;    
import org.springframework.http.ResponseEntity;
import com.shop.project.DTOs.CustomersRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private final CustomerService customerService;
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/register")
    public ResponseEntity<CustomersResponse> registerCustomer(@RequestBody CustomersRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
    @GetMapping("/{name}")
    public ResponseEntity<CustomersResponse> getCustomer(@PathVariable String name){
        return ResponseEntity.ok(customerService.getCustomerByName(name));
    }
}

package com.shop.project.Service;
import com.shop.project.Repositories.CustomerRepository;
import com.shop.project.DTOs.CustomersRequest;
import com.shop.project.DTOs.CustomersResponse;
import com.shop.project.Entitys.Customers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shop.project.Mappers.CustomerMapping;
@Service
public class CustomerService {
    private final CustomerMapping customerMapping;
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerMapping customerMapping, CustomerRepository customerRepository) {
        this.customerMapping = customerMapping;
        this.customerRepository = customerRepository;
    }
public  CustomersResponse createCustomer(CustomersRequest request){
    if(customerRepository.findByEmailCustomQuery(request.getEmail()).isPresent()){
        throw new RuntimeException("Email already exists");
    }
    Customers customer = customerMapping.toEntity(request);
    Customers savedCustomer = customerRepository.save(customer);
    return customerMapping.toResponse(savedCustomer);
}
@Transactional(readOnly = true)
public CustomersResponse getCustomerByName(String name){
    Customers customer=customerRepository.findByName(name).orElseThrow(()->new RuntimeException("Customer not found"));
    return customerMapping.toResponse(customer);
}
@Transactional(readOnly = true)
Page<CustomersResponse> getAllCustomers(int page,int size){
    return customerRepository.findAll(PageRequest.of(page,size)).map(customerMapping::toResponse);
}   
@Transactional(readOnly = true)
public CustomersResponse getCustomersByemail(String email){
    Customers customers=customerRepository.findByEmailCustomQuery(email).orElseThrow(()->new RuntimeException("Customer not found"));      
    return customerMapping.toResponse(customers);
}
@Transactional(readOnly = true)
public CustomersResponse updateCustomer(Long id,CustomersRequest request){
    Customers customer=customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    customer.setName(request.getName());
    customer.setEmail(request.getEmail());
    Customers updatedCustomer=customerRepository.save(customer);
    return customerMapping.toResponse(updatedCustomer); 
}
@Transactional(readOnly = true)
public void deleteCustomer(Long id){
    Customers customer=customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    customerRepository.delete(customer);
}
}

package com.shop.project.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.project.Service.AddressService;
import com.shop.project.DTOs.AddressRequest;
import com.shop.project.DTOs.AddressResponse;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/create")
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest request){
         AddressResponse response = addressService.createAddress(request);
         return ResponseEntity.status(201).body(response);
    }
    @GetMapping("/{street}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable String street){
        AddressResponse response = addressService.getAddressByStreet(street);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}

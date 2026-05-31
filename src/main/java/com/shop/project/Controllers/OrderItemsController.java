package com.shop.project.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shop.project.Service.OrderItemsService;
import com.shop.project.DTOs.OrderitemRequest;
import com.shop.project.DTOs.OrderitemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping("/api/order-items")
public class OrderItemsController {
    private final OrderItemsService orderItemsService;
    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService; 
    }
    @PostMapping("/create")
    public ResponseEntity<OrderitemResponse> createOrderItems(@RequestBody OrderitemRequest request){
        OrderitemResponse response=orderItemsService.createOrderItems(request);
        return ResponseEntity.status(201).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderitemResponse> getOrderItemsById(@PathVariable Long id){
        OrderitemResponse response=orderItemsService.getOrderItemsById(id);
        return ResponseEntity.ok(response);
    }
   @GetMapping("/order/{orderId}")
public ResponseEntity<Page<OrderitemResponse>> findByOrderId(
        @PathVariable Long orderId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

    Page<OrderitemResponse> response =
            orderItemsService.findByOrderId(orderId, page, size);

    return ResponseEntity.ok(response);
}
@GetMapping("/product/{productId}")
public ResponseEntity<Page<OrderitemResponse>> findByProductId(
    @PathVariable Long productId,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size) {

    Page<OrderitemResponse> response =
            orderItemsService.findByProductId(productId, page, size);

    return ResponseEntity.ok(response);
}
}

package com.shop.project.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.project.Service.OrderService;
import com.shop.project.DTOs.OrdersRequest;
import com.shop.project.DTOs.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
     @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrdersRequest request){
        OrderResponse response=orderService.createOrder(request);
        return ResponseEntity.status(201).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id){
        OrderResponse response=orderService.getOrderById(id);
        return ResponseEntity.ok(response);
}
@GetMapping
    public ResponseEntity<Page<OrderResponse>> getAllOrders(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        Page<OrderResponse> response=orderService.getAllOrders(page,size);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/status")
    public ResponseEntity<OrderResponse> findByStatus(@RequestParam String status){
        OrderResponse response=orderService.findByStatus(status);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/date")
    public ResponseEntity<Page<OrderResponse>> findByOrderDateBetween(@RequestParam String startDate,@RequestParam String endDate,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        java.time.LocalDate start=java.time.LocalDate.parse(startDate);
        java.time.LocalDate end=java.time.LocalDate.parse(endDate);
        Page<OrderResponse> response=orderService.findByOrderDateBetween(start,end,page,size);
        return ResponseEntity.ok(response);
    }
}

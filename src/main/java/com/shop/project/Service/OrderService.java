package com.shop.project.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shop.project.Entitys.Orders;
import com.shop.project.DTOs.OrderResponse;
import com.shop.project.Mappers.OrderMapping;
import com.shop.project.Repositories.OrdersRepository;
import com.shop.project.DTOs.OrdersRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public class OrderService {
    private final OrderMapping orderMapping;
    private final OrdersRepository orderRepository;
    public OrderService(OrderMapping orderMapping, OrdersRepository orderRepository) {
        this.orderMapping = orderMapping;
        this.orderRepository = orderRepository;
    }
    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id){
        Orders order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        return orderMapping.toResponse(order);
    }
    @Transactional
    public OrderResponse createOrder(OrdersRequest request){
        Orders order=orderMapping.toEntity(request);
        Orders savedOrder=orderRepository.save(order);
        return orderMapping.toResponse(savedOrder);
    }
    @Transactional
    public void deleteOrder(Long id){
        Orders order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
    @Transactional(readOnly = true)
    public Page<OrderResponse> getAllOrders(int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        return orderRepository.findAll(pageable).map(orderMapping::toResponse);
    }
    @Transactional(readOnly = true)
    public OrderResponse findByStatus(String status){
        Orders order=orderRepository.findByStatus(status).orElseThrow(()->new RuntimeException("Order not found"+status));
        return orderMapping.toResponse(order);
    }
    @Transactional(readOnly = true) 
    public Page<OrderResponse> findByOrderDateBetween(java.time.LocalDate startDate, java.time.LocalDate endDate, int page, int size){
        Pageable pageable=PageRequest.of(page,size);
        return orderRepository.findByOrderDateBetween(startDate,endDate,pageable).map(orderMapping::toResponse);
    }

}
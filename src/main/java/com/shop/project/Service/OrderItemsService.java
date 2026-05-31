package com.shop.project.Service;

import org.springframework.stereotype.Service;
import com.shop.project.Repositories.OrderItemsRepository;
import com.shop.project.Mappers.OrderItemsMapping;
import org.springframework.transaction.annotation.Transactional;
import com.shop.project.DTOs.OrderitemRequest;
import com.shop.project.DTOs.OrderitemResponse;
import com.shop.project.Entitys.OrderItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;
    private final OrderItemsMapping orderItemsMapping;
    public OrderItemsService(OrderItemsRepository orderItemsRepository, OrderItemsMapping orderItemsMapping) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderItemsMapping = orderItemsMapping;
    }
@Transactional(readOnly=true)   
 public OrderitemResponse createOrderItems(OrderitemRequest request){
    OrderItems orderItem=orderItemsMapping.toEntity(request);
    OrderItems savedOrderItem=orderItemsRepository.save(orderItem);
    return orderItemsMapping.toResponse(savedOrderItem);
 }
@Transactional(readOnly=true)
public OrderitemResponse getOrderItemsById(Long id){
    OrderItems orderItem=orderItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Order item not found"));
    return orderItemsMapping.toResponse(orderItem);
}
@Transactional
public void deleteOrderItems(Long id){
    OrderItems orderItem=orderItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Order item not found"));
    orderItemsRepository.delete(orderItem);
}
@Transactional(readOnly=true)
 public Page<OrderitemResponse> findByOrderId(Long orderId,int page,int size){
    Pageable pageable =PageRequest.of(page,size);
    return orderItemsRepository.findByOrderId(orderId,pageable).map(orderItemsMapping::toResponse);
}
@Transactional(readOnly=true)
public Page<OrderitemResponse> findByProductId(Long productId,int page,int size){
    Pageable pageable=PageRequest.of(page,size);
    return orderItemsRepository.findByProductId(productId, pageable).map(orderItemsMapping::toResponse);
}
    
}

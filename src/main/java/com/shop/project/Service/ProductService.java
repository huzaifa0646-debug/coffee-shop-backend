package com.shop.project.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.project.DTOs.ProductRequest;
import com.shop.project.DTOs.ProductResponse;
import com.shop.project.Mappers.ProductMapping;
import com.shop.project.Repositories.ProductRepository;
import com.shop.project.Entitys.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapping productMapping;
    public ProductService(ProductRepository productRepository, ProductMapping productMapping) {
        this.productRepository = productRepository;
        this.productMapping = productMapping;
    }
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return productMapping.toResponse(product);
    }
    @Transactional(readOnly = true)
   public Page<ProductResponse> getAllProducts(int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        Page<Product> products=productRepository.findAll(pageable);
        return products.map(productMapping::toResponse);
    }
    @Transactional(readOnly = true)
    public Page<ProductResponse> getProductsByName(String name,int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        Page<Product> product=productRepository.findByName(name, pageable);
        return product.map(productMapping::toResponse);
    }
    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest){
        Product toEntity=productMapping.toEntity(productRequest);
        Product savedproduct=productRepository.save(toEntity);
        return productMapping.toResponse(savedproduct);
    }
    @Transactional
    public void deleteProduct(Long id){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));  
        productRepository.delete(product);
    }
    

}

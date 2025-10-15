package com.example.service;

import com.example.entity.Product;
import com.example.payload.request.ProductDto;
import com.example.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse saveProduct(ProductDto productDto);
    ProductResponse updateProduct(ProductDto productDto, Long id);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getProductsByCategory(String category);
    String deleteProduct(Long id);
}

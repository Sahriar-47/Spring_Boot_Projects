package com.example.service;

import com.example.payload.request.ProductDto;
import com.example.payload.response.ProductResponse;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductService {
    ProductResponse saveProduct(ProductDto productDto);
    ProductResponse updateProduct(ProductDto productDto, Long id);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getAllProducts();
    Page<ProductResponse> getAllProductsWithPagination(int ofset, int limit);
    Page<ProductResponse> getAllProductsWithPaginationAndSort(int ofset, int limit, String fieldName);
    List<ProductResponse> getAllProductsSortWithField(String fieldName);
    List<ProductResponse> getProductsByCategory(String category);
    String deleteProduct(Long id);

}

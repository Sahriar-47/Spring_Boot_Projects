package com.example.map;

import com.example.entity.Product;
import com.example.payload.response.ProductResponse;

public class ProductMapper {
    public static ProductResponse mapToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setUnit(product.getUnit());
        productResponse.setProductCategory(product.getProductCategory());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        return productResponse;
    }
}


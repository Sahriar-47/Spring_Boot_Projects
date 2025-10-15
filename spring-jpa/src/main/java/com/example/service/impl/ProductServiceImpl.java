package com.example.service.impl;

import com.example.entity.Product;
import com.example.payload.request.ProductDto;
import com.example.payload.response.ProductResponse;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.map.ProductMapper.mapToResponse;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName((productDto.getName()));
        product.setDescription((productDto.getDescription()));
        product.setPrice(productDto.getPrice());
        product.setUnit(productDto.getUnit());
        product.setProductCategory(productDto.getProductCategory());

        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(ProductDto productDto, Long id) {
        Product existingProduct =  productRepository.findById(id).orElse(null);

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setUnit(productDto.getUnit());
        existingProduct.setProductCategory(productDto.getProductCategory());

        Product updateProduct = productRepository.save(existingProduct);
        return mapToResponse(updateProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        return mapToResponse(existingProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        ProductResponse productResponse = new ProductResponse();

        for(Product product : productList){
            productResponseList.add(mapToResponse(product));
        }
        return productResponseList;
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        List<Product> productList = productRepository.findByProductCategory(category);
        List<ProductResponse> productResponseList = new ArrayList<>();

        ProductResponse productResponse = new ProductResponse();
        for(Product product : productList){
            productResponseList.add(mapToResponse(product));
        }
        return productResponseList;
    }

    @Override
    public String deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        productRepository.delete(existingProduct);
        return "product deleted successfully";
    }
}

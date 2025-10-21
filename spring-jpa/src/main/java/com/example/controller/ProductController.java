package com.example.controller;

import com.example.payload.request.ProductDto;
import com.example.payload.response.ProductResponse;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDto productDto) {
        ProductResponse productResponse = productService.saveProduct(productDto);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        ProductResponse productResponse = productService.updateProduct(productDto, id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse productResponse = productService.getProduct(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> productResponseList = productService.getAllProducts();
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }

    @GetMapping("/product/pagination/{ofset}/{limit}")
    public ResponseEntity<Page<ProductResponse>> getAllProductsWithPagination(
           @PathVariable int ofset, @PathVariable int limit) {
        Page<ProductResponse> page = productService.getAllProductsWithPagination(ofset, limit);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping("/product/pagination/{ofset}/{limit}/{fieldName}")
    public ResponseEntity<Page<ProductResponse>> getAllProductsWithPaginationAndSort(@PathVariable int ofset,
                                                                                     @PathVariable int limit,
                                                                                     @PathVariable String fieldName) {
        Page<ProductResponse> page = productService.getAllProductsWithPaginationAndSort(ofset, limit, fieldName);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }


    @GetMapping("/product/sort/{fieldName}")
    public ResponseEntity<List<ProductResponse>> getAllProductsSortWithField(@PathVariable String fieldName) {
        List<ProductResponse> productResponseList = productService.getAllProductsSortWithField(fieldName);
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }

    @GetMapping("/product/category/{category}")
    public ResponseEntity<List<ProductResponse>> getAllProductsByCategory(@PathVariable String category) {
        List<ProductResponse> productResponseList = productService.getProductsByCategory(category);
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted successfully", HttpStatus.OK);
    }
}

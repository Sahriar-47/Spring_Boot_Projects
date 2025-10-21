package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //find + by + fieldName
    //@Query("select p from Product p where p.productCategory = :category")
    List<Product> findByProductCategory(String category);
//    List<Product> findByName(String name);
//    List<Product> findByPriceAndUnit(Double price, Long unit);
//    List<Product> findByPriceOrUnit(Double price, Long unit);
//    List<Product> findByPriceBetween(Double lower, Double higher);
//    List<Product> findByPriceGreaterThan(Double lower);
//    List<Product> findByPriceLessThan(Double lower);
//    List<Product> findByNameIgnoreCaseContaining(String name);
}

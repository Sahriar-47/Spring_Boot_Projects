package com.example.repository;

import com.example.entity.Customer;
import com.example.modelview.CustomerModelView;
import com.example.modelview.CustomerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("select new com.example.modelview.CustomerModelView(c.name, c.email, c.phoneNo) from Customer c")
    List<CustomerModelView>  findAllCustomers();

    List<CustomerView> findByName(String name);
}

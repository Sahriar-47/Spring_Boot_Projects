package com.example.service;

import com.example.entity.Customer;
import com.example.modelview.CustomerModelView;
import com.example.modelview.CustomerView;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Integer id);
    String deleteCustomerById(Integer id);

    List<CustomerModelView> getAllCustomerByDtoProjection();
    List<CustomerView> findAllByName(String name);
}

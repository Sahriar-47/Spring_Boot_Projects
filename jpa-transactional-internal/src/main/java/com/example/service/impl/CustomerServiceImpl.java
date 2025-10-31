package com.example.service.impl;

import com.example.entity.Customer;
import com.example.modelview.CustomerModelView;
import com.example.modelview.CustomerView;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer getCustomerById(Integer id) {
        Customer c1 = customerRepository.findById(id).get();
//        Customer c2 = customerRepository.findById(id).get();
//        System.out.println(c1 == c2);
        c1.setPhoneNo("123456789");
        return c1;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        if(!CollectionUtils.isEmpty(customer.getAddresses())) {
            customer.getAddresses().forEach(address -> address.setCustomer(customer));
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) {
        Customer updatedCustomer = customerRepository.findById(id).get();
        if(updatedCustomer != null) {
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setPhoneNo(customer.getPhoneNo());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setAddresses(customer.getAddresses());
            if(!CollectionUtils.isEmpty(customer.getAddresses())) {
                customer.getAddresses().forEach(address -> address.setCustomer(updatedCustomer));
            }
        }
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public String deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        return "Customer with id " + id + " has been deleted";
    }

    @Override
    public List<CustomerModelView> getAllCustomerByDtoProjection() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public List<CustomerView> findAllByName(String name) {
        return customerRepository.findByName(name);
    }
}

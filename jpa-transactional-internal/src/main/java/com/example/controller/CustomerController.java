package com.example.controller;

import com.example.entity.Customer;
import com.example.modelview.CustomerModelView;
import com.example.modelview.CustomerView;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newCustomer,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,
                                                   @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer, id);
        return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
            return new ResponseEntity<>(customerService.deleteCustomerById(id),HttpStatus.OK);
    }

    @GetMapping("/dto/projection")
    public ResponseEntity<List<CustomerModelView>> getAllCustomerByDtoProjection() {
        List<CustomerModelView> customerModelViews = customerService.getAllCustomerByDtoProjection();
        return new ResponseEntity<>(customerModelViews,HttpStatus.OK);
    }

    @GetMapping("/interface/projection/{name}")
    public ResponseEntity<List<CustomerView>> getCustomerByInterfaceProjection(@PathVariable String name) {
        List<CustomerView> customerViews = customerService.findAllByName(name);
        return new ResponseEntity<>(customerViews,HttpStatus.OK);
    }
}

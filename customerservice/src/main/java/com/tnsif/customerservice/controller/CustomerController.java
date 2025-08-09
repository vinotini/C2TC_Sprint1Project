package com.tnsif.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // Get all customers
    @GetMapping
    public List<Customer> list() {
        return service.listAll();
    }

    // Add a new customer
    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        Customer saved = service.saveCustomer(customer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        Optional<Customer> customer = service.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getCustomerById(id).isPresent()) {
            service.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = service.getCustomerById(id);

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
            existingCustomer.setC_name(updatedCustomer.getC_name());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            Customer saved = service.saveCustomer(existingCustomer);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

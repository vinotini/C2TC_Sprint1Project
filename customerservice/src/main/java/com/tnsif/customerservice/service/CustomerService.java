package com.tnsif.customerservice.service;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    // Get all customers
    public List<Customer> listAll() {
        return repository.findAll();
    }

    // Save a new or updated customer
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findById(id);
    }

    // Delete a customer by ID
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }
}

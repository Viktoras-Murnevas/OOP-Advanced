package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

//    @Autowired
//    CustomerRepository customerRepository;  // Spring
    private MemoryCustomerRepository customerRepository;
    private CustomerService customerService;

    public MainController() {
        customerRepository = new MemoryCustomerRepository();
        customerService= new CustomerService();

    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {                              // fetchCustomers is never used, ar jis cia reikalingas?
        return customerRepository.findAll();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {          // insertCustomer is never used, ar jis cia reikalingas?
// Task 1
//        customerRepository.insert(customer);
// Task 2 and Task 3
        customerService.insertCustomer(customer);


    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerRepository.deleteById(customerId);
    }
}
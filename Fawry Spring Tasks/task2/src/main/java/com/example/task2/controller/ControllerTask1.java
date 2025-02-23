package com.example.task2.controller;

import com.example.task2.entity.Customer;
import com.example.task2.services.ServiceRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ControllerTask1 {

    @Value("${app.name:task2}")
    private String appName;


    @Autowired
    ServiceRepo1 serviceRepo1;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody  Customer customer) {
        serviceRepo1.addCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        serviceRepo1.deleteCustomer(id);
        return "customer deleted";
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return serviceRepo1.getCustomers();
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable int id, Customer customer) {
        serviceRepo1.updateCustomer(id,customer);
        return customer;
    }



}

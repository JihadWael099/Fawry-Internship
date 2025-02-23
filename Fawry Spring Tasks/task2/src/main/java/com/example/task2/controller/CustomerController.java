package com.example.task2.controller;


import com.example.task2.entity.Customer;
import com.example.task2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("api/v2")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable ("id") int id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers/name/{name}")
    public Customer getCustomerByName( @PathVariable ("name") String name) {
        List<Customer> customers= customerService.searchByName(name);
        return customers.get(0);
    }

    @GetMapping("/customers/departments/{dep}")
    public Customer getCustomerByDepartment (@PathVariable ("dep") String department) {
        List<Customer> customers= customerService.searchByDepartment(department);
        return customers.get(0);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody  Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customersPage")
    public Page<Customer> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerService.getAllCustomers(pageable);
    }

    @GetMapping("/customerPageName")
    public Page<Customer> getCustomersByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerService.getCustomersByName(name, pageable);
    }
}


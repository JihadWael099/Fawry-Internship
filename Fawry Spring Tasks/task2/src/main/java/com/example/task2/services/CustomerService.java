package com.example.task2.services;

import com.example.task2.entity.Customer;
import com.example.task2.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepo customerRepo;


    public Customer findCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        return customer.orElse(null);

    }
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }
    public  List<Customer> searchByName(String name) {
        return customerRepo.findByName(name);
    }

    public  List<Customer> searchByDepartment(String department) {
        return customerRepo.findByDepartmentName(department);
    }

    public Customer saveCustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    public Page<Customer> getCustomersByName(String name, Pageable pageable) {
        return customerRepo.findByNameContaining(name, pageable);
    }
}

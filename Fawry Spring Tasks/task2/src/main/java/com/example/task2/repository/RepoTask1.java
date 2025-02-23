package com.example.task2.repository;

import com.example.task2.entity.Customer;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoTask1 {

    public void addCustomer(Customer customer);
    public List<Customer> getCustomers();
    public String updateCustomer(int id,Customer customer);
    public String deleteCustomer(int id);
}

package com.example.task2.services;

import com.example.task2.entity.Customer;
import com.example.task2.repository.RepoTask1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRepo1 implements RepoTask1 {

    private final List<Customer> customers = new ArrayList<>();
    @Override
    public void addCustomer(Customer customer) {
     customers.add(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String updateCustomer( int id ,Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setName(updatedCustomer.getName());
                return "Customer updated successfully!";
            }
        }
        return "Customer not found!";
    }

    @Override
    public String deleteCustomer(int id) {
        Optional<Customer> customerToRemove = customers.stream().filter(customer -> customer.getId() == id)
                .findFirst();
        if (customerToRemove.isPresent()) {
            customers.remove(customerToRemove.get());
            return "Customer deleted successfully!";
        } else {
            return "Customer not found!";
        }

    }
}

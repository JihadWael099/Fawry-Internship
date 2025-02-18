package com.seroter.task1.services;

import com.seroter.task1.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudService {
    List<Customer> customers=new ArrayList<Customer>();
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Customer customerToAdd) {
        customers.add(customerToAdd);
    }
    public void deleteCustomer(Customer customerToDelete) {
        customers.remove(customerToDelete);
    }
}

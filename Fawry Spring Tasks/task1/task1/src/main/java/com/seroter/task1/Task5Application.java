package com.seroter.task1;

import com.seroter.task1.appConfig.AppConfig;
import com.seroter.task1.entity.Customer;
import com.seroter.task1.services.CrudService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
public class Task5Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CrudService crudService = (CrudService) context.getBean("crudService");
        Customer customer = (Customer) context.getBean("customer");
        customer.setId(1);
        customer.setAge(13);
        customer.setName("gehad");

        crudService.setCustomers(customer);
        List<Customer> list=crudService.getCustomers();
        System.out.println(list);

        crudService.deleteCustomer(customer);
        list=crudService.getCustomers();
        System.out.println(list);
    }
}

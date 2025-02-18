package com.seroter.task1;

import com.seroter.task1.appConfig.AppConfig;
import com.seroter.task1.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task2Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Customer customer = context.getBean(Customer.class);

        customer.setName("Noran");
        customer.setAge(12);
        customer.setId(7);

        System.out.println(customer.toString());

        context.close();
    }
}

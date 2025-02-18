package com.seroter.task1;

import com.seroter.task1.entity.Customer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task1Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.xml");
		Customer customer =  context.getBean("customer", Customer.class);
		customer.setName("gehad");
		customer.setAge(12);
		customer.setId(7);
		System.out.println(customer.toString());


		BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.context.xml");
		Customer bean =  context.getBean("customer", Customer.class);
		bean.setName("wael");
		bean.setAge(82);
		bean.setId(57);
		System.out.println(bean.toString());
	}

}

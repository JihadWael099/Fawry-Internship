package com.seroter.task1;

import com.seroter.task1.appConfig.AppConfig;
import com.seroter.task1.entity.Account;
import com.seroter.task1.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task3Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.context.xml");
        Account account =  context.getBean("account", Account.class);
        account.setId(12);
        account.setName("John Doe");
        account.setPassword("1234567890");
        System.out.println(account.toString()+" "+account.hashCode());

        Account account2 =  context.getBean("account", Account.class);
        account2.setId(454);
        account2.setName("hehe");
        account2.setPassword("sjhhajsjhas");
        System.out.println(account2.toString()+" "+account2.hashCode());


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Account account1 = annotationConfigApplicationContext.getBean(Account.class);
        account1.setName("Noran");
        account1.setPassword("554545454545");
        account1.setId(7);
        System.out.println(account1.toString()+" "+account1.hashCode());




    }
}

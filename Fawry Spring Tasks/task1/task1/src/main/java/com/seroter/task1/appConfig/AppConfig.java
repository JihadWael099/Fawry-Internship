package com.seroter.task1.appConfig;


import com.seroter.task1.entity.Account;
import com.seroter.task1.entity.Customer;
import com.seroter.task1.services.BalanceService;
import com.seroter.task1.services.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.seroter.task1.services")
public class AppConfig {

    @Bean
    @Lazy
    public Customer customer() {
        return new Customer();
    }
    @Bean
    @Lazy
    public Account account() {
        return new Account();
    }

    @Bean
    @Lazy
    public CrudService crudService() {
        return new CrudService();
    }
}

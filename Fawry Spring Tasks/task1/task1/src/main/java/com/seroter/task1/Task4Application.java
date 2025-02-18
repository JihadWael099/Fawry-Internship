package com.seroter.task1;

import com.seroter.task1.appConfig.AppConfig;
import com.seroter.task1.services.WithdrawService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task4Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WithdrawService withdrawService = context.getBean(WithdrawService.class);
        withdrawService.withdraw(200);
        withdrawService.withdraw(900);

    }
}

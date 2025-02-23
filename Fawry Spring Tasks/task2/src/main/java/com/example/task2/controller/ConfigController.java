package com.example.task2.controller;

import com.example.task2.entity.AppConfig;
import com.example.task2.entity.SmsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ConfigController {

    @Value("${spring.application.name:anyName}")
    private String appName;
    private final AppConfig appConfig;
    private final SmsConfig smsConfig;
    public ConfigController(AppConfig appConfig, SmsConfig smsConfig) {
        this.appConfig = appConfig;
        this.smsConfig = smsConfig;
    }

    @GetMapping("/name")
    public String readProbFromAppConfig() {
        return appName;
    }

    @GetMapping("/details")
    public String getAppDetails() {
        return "App Name: " + appConfig.getName() + ", Port: " + appConfig.getPort();
    }
    @GetMapping("/details/sms")
    public String getSmsDetails() {
        return "Email: " + smsConfig.getEmail() + ", host: " + smsConfig.getHost();
    }

}

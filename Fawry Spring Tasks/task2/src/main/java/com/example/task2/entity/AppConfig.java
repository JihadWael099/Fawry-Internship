package com.example.task2.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    @NotBlank(message = "App name cannot be blank")
    private String name;

    @Min(value = 1,message = "number must be greather than 0")
    private int port ;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }




}
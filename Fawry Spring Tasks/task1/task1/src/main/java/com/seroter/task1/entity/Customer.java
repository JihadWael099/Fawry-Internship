package com.seroter.task1.entity;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Customer {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @PostConstruct
    public void init(){
        System.out.println("from init method ");
    }
    @PreDestroy
    public void  destroy(){
        System.out.println("from destroy method ");
    }
}

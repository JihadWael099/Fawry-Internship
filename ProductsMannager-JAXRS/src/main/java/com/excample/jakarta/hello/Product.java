package com.excample.jakarta.hello;

public class Product {
    private String name;
    private double price;
    private int id;
    public Product(String name, double price, int id) {
       if (name==null ||name.length()>100){
           throw  new RuntimeException("invalid name ");
       }
       if(price<0){
           throw  new RuntimeException("invalid price ");
       }
       this.name = name;
       this.price = price;
       this.id = id;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name==null ||name.length()>100){
            throw new RuntimeException("invalid name ");
        }
        this.name = name;
    }
    public double getPrice() {
        if(price<0){throw new  RuntimeException("invalid price ");}
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

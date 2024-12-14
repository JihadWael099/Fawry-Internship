package com.excample.jakarta.hello;

import java.util.ArrayList;
import java.util.List;

public class ProductMannager {

    private static  List<Product> productList = new ArrayList<>();

    public void AddProduct(Product product){
        productList.add(product);
    }
    public List<Product>GetAllProducts(){
        return productList;
    }
    public Product GetProductByName(String name){
        Product product = null;
        for(Product productL : productList){
            if(productL.getName().equals(name)){
                product=productL;
            }
        }
        return product;
    }
    public void DeleteProduct(String name){
        int deleteIndex = 0;
       for(Product productL : productList){
           if(productL.getName().equals(name)){
               productList.remove(productL);
               deleteIndex=1;
               break;
           }
       }
       if(deleteIndex==0){
           throw new RuntimeException("Product not found");
       }
    }
    public void updateProduct(String name, int price) {
        int updated=0;
        for (Product product : productList) {
            if (product.getName().equals(name) ) {
                product.setName(name);
                product.setPrice(price);
                updated=1;
                break;
            }
        }
        if(updated==0)throw new RuntimeException("Product not found");
    }

}

package com.excample.jakarta.hello;

import java.util.ArrayList;
import java.util.List;

public class ProductMannager {

    private static  List<Product> productList = new ArrayList<>();

    static {
        // Adding sample products to the list
        productList.add(new Product("Product 1", 19.99, 1));
        productList.add(new Product("Product 2", 29.99, 2));
        productList.add(new Product("Product 3", 39.99, 3));
        productList.add(new Product("Product 4", 49.99, 4));
        productList.add(new Product("Product 5", 59.99, 5));
    }
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
    public void updateProduct(String oldname,String newname, double newprice) {
        int updated=0;
        for (Product product : productList) {
            if (product.getName().equals(oldname) ) {
                product.setName(newname);
                product.setPrice(newprice);
                updated=1;
                break;
            }
        }
        if(updated==0)throw new RuntimeException("Product not found");
    }

}

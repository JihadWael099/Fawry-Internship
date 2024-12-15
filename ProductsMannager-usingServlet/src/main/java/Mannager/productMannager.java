package Mannager;

import ProductModel.Product;
import java.util.ArrayList;
import java.util.List;

public class productMannager
{
    private static  List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        if(!productList.contains(product)){
            if(product.getName().length()>=100)throw new RuntimeException("Product name too long");
            if(product.getPrice()<0)throw new RuntimeException("negative price not allowed");
            productList.add(product);
        }
        else throw new RuntimeException("product already exists");
    }
    public void DeleteProduct(String name){
      for(Product product : productList){
          if(!product.getName().equals(name))throw new RuntimeException("Product not found to delete");
          productList.remove(product);
      }
    }
    public void updateProduct(String oldname,String newname,double newprice) {
        for(Product product : productList){
            if(product.getName().equals(oldname)){
                if(newname.length()>=100)throw new RuntimeException("Product name too long");
                if(product.getPrice()<0)throw new RuntimeException("negative price not allowed");
                product.setName(newname);
                product.setPrice((int) newprice);
            }
        }
    }
    public Product searchProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    public List<Product> getAllProducts() {
        return productList;
    }
    public Product getProductByName(String name){

        Product product=null;
        for(Product p:productList){
            if(p.getName().equals(name)){
                product=p;
                break;
            }
        }
        return product;

    }


}

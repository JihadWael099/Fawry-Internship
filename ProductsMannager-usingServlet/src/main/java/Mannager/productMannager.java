package Mannager;

import ProductModel.Product;
import java.util.ArrayList;
import java.util.List;

public class productMannager
{
    private static  List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }
    public void DeleteProduct(int id){
      for(int i=0;i<productList.size();i++){
          if(productList.get(i).getId()==id)
          {
              productList.remove(i);
              break;
          }
      }

    }
    public boolean updateProduct(int id, String name, int price) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                return true;
            }
        }
        return false;
    }
    public Product searchProduct(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
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

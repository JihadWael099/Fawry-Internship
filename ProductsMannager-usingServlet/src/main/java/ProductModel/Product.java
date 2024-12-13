package ProductModel;

public class Product {

    private String name;
    private int price;
    private int id;

    public Product(String name, int price, int id){
        this.name=name;
        this.price=price;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

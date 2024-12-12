package Store;

import example.account.AccountManager;
import example.account.Customer;
import example.store.Product;
import example.store.Store;
import example.store.StoreImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class StoreTest
{

    static class SuccessAcountManager implements AccountManager {

        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "success";
        }
    }

    static class InsufficientAccountBalanceAcountManager implements AccountManager {

        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "insufficient account balance";
        }
    }

    static class MaximumCreditExceededAcountManager implements AccountManager {

        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "maximum credit exceeded";
        }
    }



    @Test
    void BuyProductWithStockOfProductWithSuccess(){
        Customer customer=new Customer();
        Product product=new Product();
        product.setQuantity(5);
        Store store=new StoreImpl(new SuccessAcountManager());
        store.buy(product,customer);
        Assertions.assertEquals(4,product.getQuantity());
    }

    @Test
    void BuyProductWithOutStockOfProductWithException(){
        Customer customer=new Customer();
        Product product=new Product();
        product.setQuantity(0);
        Store store=new StoreImpl(new SuccessAcountManager());
        try{
            store.buy(product,customer);
            Assertions.fail("Faild");
        }catch (RuntimeException e){
            Assertions.assertEquals("Product out of stock",e.getMessage());
        }


    }
    @Test
    void BuyProductWithStockOfProductWithException_InsufficientAccountBalance(){
        Customer customer=new Customer();
        Product product=new Product();
        product.setQuantity(4);

        Store store=new StoreImpl(new InsufficientAccountBalanceAcountManager());
        try{
            store.buy(product,customer);
            Assertions.fail("Faild");
        }catch (RuntimeException e){
            Assertions.assertEquals("Payment failure: "+"insufficient account balance",e.getMessage());
        }


    }

    @Test
    void BuyProductWithStockOfProductWithException_MaximumCreditExceeded(){

        Customer customer=new Customer();
        Product product=new Product();
        product.setQuantity(4);

        Store store=new StoreImpl(new MaximumCreditExceededAcountManager());
        try{
            store.buy(product,customer);
            Assertions.fail("Faild out of stock");
        }catch (RuntimeException e){
            Assertions.assertEquals("Payment failure: "+"maximum credit exceeded",e.getMessage());
        }


    }

}

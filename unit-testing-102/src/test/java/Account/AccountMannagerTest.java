package Account;

import example.account.AccountManager;
import example.account.AccountManagerImpl;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountMannagerTest {
    AccountManager accountManager=new AccountManagerImpl();
    @Test
    void givenCustomerWithBalance_whenWithdraw_thenSuccess()
    {
        Customer customer=new Customer();
        customer.setBalance(100);
        Assertions.assertEquals("success", accountManager.withdraw(customer, 50));
        Assertions.assertEquals(50,customer.getBalance());
    }
    @Test
    void GivenCustomerWithBalanceWhenWithdrawWithNotCreditAllowed_theninsufficient(){
        Customer customer=new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);
        Assertions.assertEquals("insufficient account balance",accountManager.withdraw(customer,200));
        Assertions.assertEquals(100,customer.getBalance());
    }
    @Test
    void GivenCustomerWithBalanceWhenWithdrawWithNotCreditAllowed_success(){
        Customer customer=new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);
        Assertions.assertEquals("success",accountManager.withdraw(customer,100));
        Assertions.assertEquals(0,customer.getBalance());
    }
    @Test
    void GivenCustomerWithBalanceWhenWithdrawWithNegativeorZeroValue_thenNegativeValueNotAllowed(){
        Customer customer=new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);
        Assertions.assertEquals("zero or negative value not allowed",accountManager.withdraw(customer,-100));
        Assertions.assertEquals(100,customer.getBalance());
    }


    @Test
    void GivenCustomerWithBalanceWhenWithdrawWithCreditAllowed_thenSuccess(){
        Customer customer=new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        Assertions.assertEquals("success",accountManager.withdraw(customer,200));
        Assertions.assertEquals(-100,customer.getBalance());
    }



    @Test
    void GivenCustomerWithBalanceWhenWithdraw_thenMaximumCreditExceeded(){
        Customer customer=new Customer();
        customer.setBalance(-1000);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        Assertions.assertEquals("maximum credit exceeded",accountManager.withdraw(customer,200));
        Assertions.assertEquals(-1000,customer.getBalance());
    }


    @Test
    void GivenCustomerWithBalanceWhenWithdraw_thenMaximumCreditExceededVIP(){
        Customer customer=new Customer();
        customer.setBalance(-1000);
        customer.setVip(true);
        customer.setCreditAllowed(true);
        Assertions.assertEquals("success",accountManager.withdraw(customer,200));
        Assertions.assertEquals(-1200,customer.getBalance());
    }
}

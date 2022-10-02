import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TestCustomer {

    Customer aCustomer;
    Customer anotherCustomer;

    @Before
    public void setup(){
        aCustomer = new Customer("Bob", 0, 0.0, 0.0 );
        anotherCustomer = new Customer ("Bill", 0, 99, 1000);
    }

    @Test
    public void testDeposit(){
        double amountSaving = aCustomer.deposit(100, new Date(), Customer.SAVING);
        assertTrue (amountSaving ==100);

        double amountChequing = aCustomer.deposit( 100, new Date(), Customer.CHECKING);
        assertTrue (amountChequing == 100);
    }

    @Test
    public void testWithdraw(){
        double amountChequing = anotherCustomer.withdraw (100, new Date(), Customer.CHECKING);
        assertTrue (amountChequing == -1 );

        double amountSaving = anotherCustomer.withdraw ( 100, new Date(), Customer.SAVING);
        assertTrue (amountSaving == 900);

        double amountSaving1 = anotherCustomer.withdraw ( 1001, new Date(), Customer.SAVING);
        assertTrue (amountSaving1 == 900);
    }


}

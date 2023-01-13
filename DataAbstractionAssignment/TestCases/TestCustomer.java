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
        //assures a customer can deposit in savings
        double amountSaving = aCustomer.deposit(100, new Date(), Customer.SAVING);
        assertTrue (amountSaving ==100);
        //assures a customer can deposit in chequings
        double amountChequing = aCustomer.deposit( 100, new Date(), Customer.CHECKING);
        assertTrue (amountChequing == 100);
    }

    @Test
    public void testWithdraw(){
        //tests valid customer withdraw in checking with overdraft
        double amountChequing = anotherCustomer.withdraw (100, new Date(), Customer.CHECKING);
        assertTrue (amountChequing == -1 );
        //tests regular customer withdraw in saving (without overdraft)
        double amountSaving = anotherCustomer.withdraw ( 100, new Date(), Customer.SAVING);
        assertTrue (amountSaving == 900);
        //tests invalid customer withdraw in saving (when overdraft still isn't enough)
        double amountSaving1 = anotherCustomer.withdraw ( 1001, new Date(), Customer.SAVING);
        assertTrue (amountSaving1 == 900);
    }


}

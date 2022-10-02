import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestDeposit {

    Deposit depositChequing;
    Deposit depositSaving;

    @Before
    public void setup(){
        depositChequing = new Deposit(100, new Date(0), "Chequing" );
        depositSaving = new Deposit (100, new Date(0), "Savings");
    }


    @Test
    public void toStringTest(){

        Date adate = new Date(0);
        String resultSaving = "Deposit of: $" + 100.0 + " Date: " + adate.toString() + " into account: " + "Savings";
        assertTrue(depositSaving.toString().equals(resultSaving));

        String resultChequing = "Deposit of: $" + 100.0 + " Date: " + adate.toString() + " into account: " + "Chequing";
        assertTrue(depositChequing.toString().equals(resultChequing));


    }
}
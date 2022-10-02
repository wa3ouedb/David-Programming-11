import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TestWithdraw {
    Withdraw withdrawChequing;
    Withdraw withdrawSaving;

    @Before
    public void setup(){
        withdrawChequing = new Withdraw(100,new Date(0), "Chequing");
        withdrawSaving = new Withdraw(100, new Date(0), "Savings");


    }

    @Test
    public void toStringTest(){
        Date adate = new Date(0);
        String resultSaving = "Withdrawal of: $" + 100.0 + " Date: " + adate.toString() + " from account: " + "Savings";
        assertTrue (withdrawSaving.toString().equals(resultSaving));

        String resultChequing = "Withdrawal of: $" + 100.0 + " Date: " + adate.toString() + " from account: " + "Chequing";
        assertTrue(withdrawChequing.toString().equals(resultChequing));
    }


}

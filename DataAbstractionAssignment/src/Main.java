import java.sql.SQLOutput;
import java.util.Date;
//this project was completed prior to the criteria changes

public class Main {

    public static void main (String[] args){

    Deposit deposit = new Deposit(500, new Date(),"Chequing");
        System.out.println(deposit);

    Withdraw withdraw = new Withdraw(800, new Date(),"Savings");
        System.out.println(withdraw);
    }

}

import java.util.Date;

public class Deposit {
    //Deposit class fields
    private double amount;
    private Date date;
    private String account;

    //Deposit constructor
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Creates all data into a long string
    public String toString(){
        String printDeposit = "Deposit of: $" + amount + " Date: " + date.toString() + " into account: " + account;
        return printDeposit;
    }
}

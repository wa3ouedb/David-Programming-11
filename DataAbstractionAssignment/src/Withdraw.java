import java.util.Date;

public class Withdraw {
    //Withdraw class fields
    private double amount;
    private Date date;
    private String account;

    //Withdraw constructor
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //combines all data into long string
    public String toString(){
        String printWithdrawal = "Withdrawal of: $" + amount + " Date: " + date.toString() + " from account: " + account;
        return printWithdrawal;
    }
}

import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        String printWithdrawal = "Withdrawal of: $" + amount + " Date: " + date.toString() + " from account: " + account;
        return printWithdrawal;
    }
}

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        name = "" ;
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        withdraws = new ArrayList<>();
        deposits = new ArrayList<>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;

        withdraws = new ArrayList<>();
        deposits = new ArrayList<>();
    }

    public double deposit(double amt, Date date, String account){
        Deposit aDeposit = new Deposit(amt, date, account);
        deposits.add(aDeposit);
        if (account.equals(CHECKING)){
            checkBalance += amt;
            return checkBalance;
        }
        else{
            savingBalance += amt;
            return savingBalance;
        }
    }
    public double withdraw(double amt, Date date, String account){
        if (!checkOverdraft(amt, account)){
            if (account.equals(CHECKING)){
                return checkBalance;
            }
            else {
                return savingBalance;
            }
        }

        Withdraw aWithdraw = new Withdraw(amt, date, account);
        withdraws.add(aWithdraw);
        if (account.equals(CHECKING)){
            checkBalance -= amt;
            return checkBalance;
        }
        else{
            savingBalance -= amt;
            return savingBalance;
        }
    }
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)){
            return amt <= checkBalance - OVERDRAFT;
        }
        else {
            return amt <= savingBalance - OVERDRAFT;
        }
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}

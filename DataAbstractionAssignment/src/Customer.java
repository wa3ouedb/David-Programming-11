import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    //Customer class fields
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

    //original default Customer constructor
    Customer(){
        name = "" ;
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        withdraws = new ArrayList<>();
        deposits = new ArrayList<>();
    }

    //Customer constructor
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;

        withdraws = new ArrayList<>();
        deposits = new ArrayList<>();
    }

    //deposit function
    public double deposit(double amt, Date date, String account){
        Deposit aDeposit = new Deposit(amt, date, account);
        deposits.add(aDeposit);
        //add money to checking balance
        if (account.equals(CHECKING)){
            checkBalance += amt;
            return checkBalance;
        }
        //add money to saving balance
        else{
            savingBalance += amt;
            return savingBalance;
        }
    }

    //withdraw function
    public double withdraw(double amt, Date date, String account){
        double balance = checkBalance;
        if (account.equals(SAVING)){
            balance = savingBalance;
        }
        //if the amount to be withdrawn is under the balance amount
        if(amt <= balance){
            Withdraw aWithdraw = new Withdraw(amt, date, account);
            withdraws.add(aWithdraw);
            if(account.equals(CHECKING)){
                //subtract from checking
                checkBalance -= amt;
                return checkBalance;
            }
            else {
                //subtract from saving
                savingBalance -= amt;
                return savingBalance;
            }
        }
        //if the amount to be withdrawn uses the overdraft
        else if (checkOverdraft(amt, account)){
            System.out.println("You are using the Overdraft");
            Withdraw aWithdraw = new Withdraw(amt, date, account);
            withdraws.add(aWithdraw);
            if(account.equals(CHECKING)){
                checkBalance -= amt;
                return checkBalance;
            }
            else {
                savingBalance -= amt;
                return savingBalance;
            }
        }
        else {
            //if the overdraft is still not enough to complete the withdraw
           return balance;
        }

    }

    //check overdraft limit function
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

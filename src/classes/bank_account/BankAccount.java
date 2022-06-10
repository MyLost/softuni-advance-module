package classes.bank_account;

public class BankAccount {
    private int id;
    private double balance;
    private static double rate = 0.02d;
    private static int bankAccountCount = 1;

    public BankAccount() {
        this.id = bankAccountCount++;
    }
    public static void setInterestRate(double interest) {
        rate = interest;
    }

    public double getInterest(int years) {
        return this.rate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance +=amount;
    }

    public int getId() {
        return this.id;
    }
}

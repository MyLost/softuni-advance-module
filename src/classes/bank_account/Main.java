package classes.bank_account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();
        while(!"End".equals(command)) {
            String[] commandTokens = command.split("\\s+");
            String action = commandTokens[0];
            int id ;
            int amount;
            double interest;
            int years;
            switch(action) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.println("Account ID"+ account.getId() +" created");
                    break;
                case "Deposit":
                     id = Integer.parseInt(commandTokens[1]);
                    if(accounts.containsKey(id)) {
                        amount = Integer.parseInt(commandTokens[2]);
                        accounts.get(id).deposit(amount);
                        System.out.println(String.format("Deposited %d to ID%d", amount, id));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "GetInterest":
                     id = Integer.parseInt(commandTokens[1]);
                    if(accounts.containsKey(id)) {
                        years = Integer.parseInt(commandTokens[2]);
                        System.out.println(String.format("%.2f", accounts.get(id).getInterest(years)));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    interest = Double.parseDouble(commandTokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}

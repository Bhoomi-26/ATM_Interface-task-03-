import java.util.Scanner;

class AtmInterface {

    private double balance;

    public AtmInterface(double initialBalanceAmount) {
        this.balance = initialBalanceAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private AtmInterface bankAccount;
    private Scanner sc;

    public ATM(AtmInterface bankAccount) {
        this.bankAccount = bankAccount;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance Amount");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you !!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Your account balance is: " + bankAccount.getBalance() + " Rs");
    }

    private void deposit() {
        System.out.print("Enter the amount: ");
        double amount = sc.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Deposited successfully!! Your updated balance is: " + bankAccount.getBalance() + " Rs");
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Your updated balance is: " + bankAccount.getBalance() + " Rs");
        } else {
            System.out.println("Insufficient balance. Please try again with a lower amount.");
        }
    }
}

public class Atm_Interface {
    public static void main(String[] args) {
        double initialBalanceAmount = 100000.0;
        AtmInterface bankAccount = new AtmInterface(initialBalanceAmount);
        ATM atm = new ATM(bankAccount);
        atm.start();
    }
}
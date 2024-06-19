import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMainMenu() {
        System.out.println("Welcome to ATM!");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    public void processChoice(int choice) throws InsufficientFundsException {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 2:
                System.out.println("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you for using our services!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in your account.");
        }
        account.withdraw(amount);
        System.out.println("Withdrawal successful. Please collect your cash.");
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000
        ATM atm = new ATM(account);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            atm.displayMainMenu();
            choice = scanner.nextInt();
            try {
                atm.processChoice(choice);
            } catch (InsufficientFundsException e) {
                System.err.println(e.getMessage());
            }
        } while (choice != 4);

        scanner.close();
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in your account.");
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

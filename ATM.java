
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}

class OptionMenu extends Account {
    private Scanner sc = new Scanner(System.in);
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    /* Validate Login information customer number and pin number */
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                // Populating HashMap with 5 values as requested
                hm.put(11111, 111);
                hm.put(11112, 222);
                hm.put(11113, 333);
                hm.put(11114, 444);
                hm.put(11115, 111);

                System.out.println("Welcome to the ATM Project!");

                System.out.print("Enter Your Customer Number: ");
                int CN = sc.nextInt();

                System.out.print("Enter Your Pin Number: ");
                int PN = sc.nextInt();

                // Using abstraction (setters)
                setCustomerNumber(CN);
                setPinNumber(PN);

                // Retrieving values (getters)
                int P = getCustomerNumber();
                int Q = getPinNumber();

                // Validation using HashMap
                if (hm.containsKey(P) && hm.get(P) == Q) {
                    System.out.println("Login successfully");
                    getAccountType();
                    x = 2; // Break loop on success
                } else {
                    System.out.println("Login wrong");
                    // Loop continues as per original behavior interpretation, but user said 'Else
                    // Login wrong'.
                    // Retaining loop for retry capability, but message matches request.
                }
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                sc.nextLine(); // Clear buffer
                x = 1;
            }
        } while (x == 1);
    }

    /* Display Account Type Menu with selection */
    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("3 - Exit");
        System.out.print("Choice: ");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                getCurrent();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    /* Display Checking Account Menu with selections */
    public void getCurrent() {
        System.out.println("Checking Account: ");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCurrentBalance()));
                getAccountType();
                break;
            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getCurrent();
        }
    }

    /* Display Saving Account Menu with selections */
    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }
}

class Account {
    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;

    private Scanner input = new Scanner(System.in);
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set Customer Number */
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* Get Customer Number */
    public int getCustomerNumber() {
        return this.customerNumber;
    }

    /* Set Pin Number */
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get Pin Number */
    public int getPinNumber() {
        return this.pinNumber;
    }

    /* Get Current Account Balance */
    public double getCurrentBalance() {
        return this.currentBalance;
    }

    /* Get Saving Account Balance */
    public double getSavingBalance() {
        return this.savingBalance;
    }

    /* Calculate Current Account Withdrawal */
    public double calcCurrentWithdraw(double amount) {
        this.currentBalance = (this.currentBalance - amount);
        return this.currentBalance;
    }

    /* Calculate Saving Account Withdrawal */
    public double calcSavingWithdraw(double amount) {
        this.savingBalance = (this.savingBalance - amount);
        return this.savingBalance;
    }

    /* Calculate Current Account Deposit */
    public double calcCurrentDeposit(double amount) {
        this.currentBalance = (this.currentBalance + amount);
        return this.currentBalance;
    }

    /* Calculate Saving Account Deposit */
    public double calcSavingDeposit(double amount) {
        this.savingBalance = (this.savingBalance + amount);
        return this.savingBalance;
    }

    /* Customer Current Account Withdraw Input */
    public void getCurrentWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(this.currentBalance));
        System.out.print("Amount the you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((this.currentBalance - amount) >= 0) {
            calcCurrentWithdraw(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(this.currentBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Saving Account Withdraw Input */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(this.savingBalance));
        System.out.print("Amount the you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((this.savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(this.savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Current Account Deposit Input */
    public void getCurrentDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(this.currentBalance));
        System.out.print("Amount the you want to deposit from Checking Account: ");
        double amount = input.nextDouble();

        if ((this.currentBalance + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(this.currentBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Saving Account Deposit Input */
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(this.savingBalance));
        System.out.print("Amount the you want to deposit from Saving Account: ");
        double amount = input.nextDouble();

        if ((this.savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(this.savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
}

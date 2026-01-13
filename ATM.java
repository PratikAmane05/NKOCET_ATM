import java.util.*;
import java.io.*;
import java.text.*;

class account {
    private int pn;
    private int CN;
    double CB = 2000;
    double SB = 1000;
    DecimalFormat df1 = new DecimalFormat("###,##0.00 '$'");
    DecimalFormat df2 = new DecimalFormat("###,##0.00 '₹'");
    Scanner sc = new Scanner(System.in);

    void setCustomerNumber(int cn) {
        CN = cn;
    }

    void setPinNumber(int pn) {
        this.pn = pn;
    }

    int getCustomerNumeber() {
        return CN;
    }

    int getPinNumber() {
        return pn;
    }

    void getCurrentBalance() {
        System.out.println("Current Available Balance is :" + df2.format(CB));
    }

    void getSavingBalance() {
        System.out.println("Saving Available Balance is :" + df1.format(SB));
    }

    // withdraw
    void CurrentWithdrawInput() {
        System.out.println("\nCurrent Available Balance is :" + df2.format(CB));
        System.out.print("Enter Amout To Withdraw : ");
        double amount = sc.nextDouble();
        if ((CB - amount) > 0) {
            calcCurrentWithdraw(amount);
            System.out.println("\nCurrent Available Balance is :" + df2.format(CB));
        } else {
            System.out.println("Insufficient Balance");
            CurrentWithdrawInput();
        }

    }

    // withdraw calculation
    double calcCurrentWithdraw(double amt) {
        CB = CB - amt;
        return CB;

    }

    // deposite input
    void currentDepositeInput() {
        System.out.print("Enter Amout to deposite:");
        double amount_deposite = sc.nextDouble();
        calcCurrentDeposite(amount_deposite);
        if (amount_deposite > 0) {
            calcCurrentDeposite(amount_deposite);
            System.out.println("\nCurrent Available Balance is :" + df2.format(CB));
        } else {
            System.out.println("Invalid Ammout");
            currentDepositeInput();
        }

    }

    // deposite call
    double calcCurrentDeposite(double amtt) {
        CB = CB + amtt;
        return CB;
    }

    void savingWithdrawInput() {
        System.out.println("\nSaving Available Balance is :" + df1.format(SB));
        System.out.print("Enter Amout To Withdraw : ");
        double amount = sc.nextDouble();
        if ((CB - amount) > 0) {
            calcsavingWithdraw(amount);
            System.out.println("\nSaving Available Balance is :" + df1.format(SB));
        } else {
            System.out.println("Insufficient Balance");
            savingWithdrawInput();
        }

    }

    double calcsavingWithdraw(double amt) {
        SB = SB - amt;
        return SB;

    }

    void savingDepositeInput() {
        System.out.print("Enter Amout to deposite:");
        double amount_deposite = sc.nextDouble();
        if (amount_deposite > 0) {
            calcSavingDeposite(amount_deposite);
            System.out.println("\nSaving Available Balance is :" + df1.format(SB));
        } else {
            System.out.println("Invalid Ammout");
            savingDepositeInput();
        }

    }

    // deposite call
    double calcSavingDeposite(double amtt) {
        SB = SB + amtt;
        return SB;
    }

}

class option_menu extends account {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Integer> hm = new HashMap<>();

    void getlogin() {
        int i = 1;
        do {
            try {
                hm.put(11111, 111);
                hm.put(11112, 222);
                hm.put(11113, 333);
                hm.put(11114, 444);
                hm.put(11115, 111);
                System.out.println("Welcome to my ATM");
                System.out.println("Enter Customer Number");
                setCustomerNumber(sc.nextInt());
                System.out.println("Enter Pin Number");
                setPinNumber(sc.nextInt());
                int p = getCustomerNumeber();
                int q = getPinNumber();
                if (hm.containsKey(p) && hm.get(p) == q) {
                    System.out.println("Login Successful");
                    getAccountType();
                } else {
                    System.out.println("Incorrect Customer Number or Pin Number");
                    getlogin();
                }

            }

            catch (Exception g) {
                System.err.println("\nEnter Only Numbers");
                System.err.println("\nCaracters and Special Symbols are not allowed");
                sc.next();
            }
        }

        while (i == 1);
    }

    void getAccountType() {
        System.out.println("Select The Account Type");
        System.out.println("Choice : 1.Current Account 2.Saving Account 3.Exit");
        System.out.print("Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                getcurrent();
                break;
            case 2:
                getsaving();
                break;
            case 3:
                System.out.println("visit Again\n");
                break;
            default:
                System.out.println("Invalid Choice");
                getAccountType();
                break;
        }
    }

    void getcurrent() {
        System.out.println("\n Current Account");
        System.out.println("\n Choice 1: Balance Enquiry");
        System.out.println("\n Choice 2: Withdraw Money");
        System.out.println("\n Choice 3: Deposite Money");
        System.out.println("\n Choice 4: Exit");
        System.out.print("Choice : ");
        int c = sc.nextInt();
        switch (c) {
            case 1:
                getCurrentBalance();
                getAccountType();
            case 2:
                CurrentWithdrawInput();
                getAccountType();
            case 3:
                currentDepositeInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Visit Again /n");
                break;
            default:
                System.out.println("Invalid Choice");
                getcurrent();
        }
    }

    void getsaving() {
        System.out.println("\n Saving Account");
        System.out.println("\n Choice 1: Balance Enquiry");
        System.out.println("\n Choice 2: Withdraw Money");
        System.out.println("\n Choice 3: Deposite Money");
        System.out.println("\n Choice 4: Exit");
        System.out.print("Choice : ");
        int c = sc.nextInt();
        switch (c) {
            case 1:
                getSavingBalance();
                getAccountType();
                break;
            case 2:
                savingWithdrawInput();
                getAccountType();
            case 3:
                savingDepositeInput();
                getAccountType();
            case 4:
                System.out.println("Visit Again");
                break;

            default:
                System.out.println("Invalid Choice");
                getsaving();

        }

    }
}

public class ATM extends account {
    public static void main(String[] args) {
        option_menu op = new option_menu();
        // op.getlogin();
        op.getAccountType();

    }
}
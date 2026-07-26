package com.tejas.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account(101, "Tejas", 1000);

        while (true) {

            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter the amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successful");
                    break;

                case 2:
                    System.out.print("Enter the amount: ");
                    double withdrawAmount = sc.nextDouble();
                    try{
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdraw Successful");
                    } catch (InsufficientFundsException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Avalable Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Transaction History");
                    for(Transaction t : account.getTransactions()){
                        System.out.println(t);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the System!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

package com.tejas.bank;

import java.util.ArrayList;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount){
        balance = balance + amount;
        transactions.add(new Transaction("DEPOSIT", amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient Funds");
        }

        balance = balance - amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public double getBalance(){
        return balance;
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    @Override
    public String toString(){
        return "Account Number: " + accountNumber +
                "\nAccount Holder: " + accountHolderName +
                "\nBalance: " + balance;
    }
}

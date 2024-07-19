package com.example.BankAccount;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money into the account
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing " + amount);
        balance += amount;
        System.out.println("Balance after deposit by " + Thread.currentThread().getName() + ": " + balance);
    }

    // Synchronized method to withdraw money from the account
    public synchronized void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Balance after withdrawal by " + Thread.currentThread().getName() + ": " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName() + " to withdraw " + amount);
        }
    }

	public String getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

}


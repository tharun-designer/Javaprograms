package com.example.BankAccount;
import com.example.BankAccount.*;
public class BankAccountTest {
    public static void main(String[] args) {
        // Create a BankAccount with initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create threads to deposit and withdraw money
        Thread thread1 = new Thread(() -> {
            account.deposit(100);
            account.withdraw(200);
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            account.deposit(200);
            account.withdraw(300);
        }, "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balance
       System.out.println("Final Balance:" + account.getBalance());
    }
}
package com.example.Immutable;

public class ImmutableDemo {
	 public static void main(String[] args) throws InterruptedException {
	        ImmutableData immutableData = new ImmutableData("Initial Data");

	        // Creating multiple threads to access immutable data
	        Thread thread1 = new Thread(() -> {
	            System.out.println("Thread 1: " + immutableData.getData());
	        });

	        Thread thread2 = new Thread(() -> {
	            System.out.println("Thread 2: " + immutableData.getData());
	        });

	        thread1.start();
	        thread2.start();

	        // Wait for threads to complete
	        thread1.join();
	        thread2.join();
	    }
	}
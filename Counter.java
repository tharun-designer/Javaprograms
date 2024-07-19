package com.example.Counter;

public class Counter {
	 private int count;

	    public Counter() {
	        this.count = 0;
	    }

	    // Synchronized method to increment the counter
	    public synchronized void increment() {
	        count++;
	    }

	    // Synchronized method to decrement the counter
	    public synchronized void decrement() {
	        count--;
	    }

	    // Method to get the current count value
	    public synchronized int getCount() {
	        return count;
	    }
	
}

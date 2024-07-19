package com.example.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5; // Capacity of the buffer

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    // Buffer is full, wait for consumer to consume
                    wait();
                }

                System.out.println("Producer produced: " + value);
                buffer.add(value++);

                // Notify the consumer thread that data is available now
                notify();

                // Introducing some delay for demonstration purposes
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    // Buffer is empty, wait for producer to produce
                    wait();
                }

                int consumedValue = buffer.poll();
                System.out.println("Consumer consumed: " + consumedValue);

                // Notify the producer thread that buffer has space now
                notify();

                // Introducing some delay for demonstration purposes
                Thread.sleep(1000);
            }
        }
    }
}


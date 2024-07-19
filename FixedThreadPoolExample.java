package com.example.fixedthreadpool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolExample {

    // Task for complex calculation
    static class ComplexCalculationTask implements Callable<Long> {
        private final int taskId;

        public ComplexCalculationTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Long call() {
            System.out.println("Task " + taskId + ": Starting complex calculation");
            long result = 0;
            for (int i = 0; i < 1000000; i++) {
                result += (long) i * i;
            }
            System.out.println("Task " + taskId + ": Complex calculation result is " + result);
            return result;
        }
    }

    // Task for simulated I/O operation
    static class SimulatedIoTask implements Callable<Double> {
        private final int taskId;

        public SimulatedIoTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Double call() {
            System.out.println("Task " + taskId + ": Starting I/O operation");
            double timeToSleep = 1 + Math.random() * 2;  // Simulate variable I/O latency between 1 and 3 seconds
            try {
                Thread.sleep((long) (timeToSleep * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + taskId + ": I/O operation completed after " + timeToSleep + " seconds");
            return timeToSleep;
        }
    }

    public static void main(String[] args) {
        // List of tasks
        List<Callable<?>> tasks = new ArrayList<>();
        tasks.add(new ComplexCalculationTask(1));
        tasks.add(new ComplexCalculationTask(2));
        tasks.add(new SimulatedIoTask(3));
        tasks.add(new SimulatedIoTask(4));
        tasks.add(new ComplexCalculationTask(5));
        tasks.add(new SimulatedIoTask(6));

        // Create a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // Submit tasks to the thread pool and collect futures
            List<Future<?>> futures = new ArrayList<>();
            for (Callable<?> task : tasks) {
                futures.add(executor.submit(task));
            }

            // Wait for all tasks to complete and get their results
            for (Future<?> future : futures) {
                try {
                    Object result = future.get();
                    System.out.println("Task result: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            // Shut down the executor service
            executor.shutdown();
        }

        System.out.println("All tasks have been completed.");
    }
}




package com.example.PrimeNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeNumberCalculator {

    // Method to calculate prime numbers up to maxNumber using ExecutorService
    public List<Integer> calculatePrimes(int maxNumber) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<List<Integer>>> futures = new ArrayList<>();

        // Submit tasks to ExecutorService
        int batchSize = 1000; // adjust batch size as needed
        for (int i = 2; i <= maxNumber; i += batchSize) {
            int start = i;
            int end = Math.min(i + batchSize - 1, maxNumber);
            Future<List<Integer>> future = executor.submit(() -> findPrimesInRange(start, end));
            futures.add(future);
        }

        List<Integer> primes = new ArrayList<>();
        // Collect results from futures
        for (Future<List<Integer>> future : futures) {
            primes.addAll(future.get());
        }

        executor.shutdown();
        return primes;
    }

    // Helper method to find prime numbers in a range [start, end]
    private List<Integer> findPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

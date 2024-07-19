package com.example.PrimeNumber;
import java.util.concurrent.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.example.PrimeNumber.PrimeNumberCalculator;
public class PrimeNumberCalculatorTest {


    // Method to write prime numbers to a file asynchronously
    public CompletableFuture<Void> writePrimesToFileAsync(List<Integer> primes, String filename) {
        return CompletableFuture.runAsync(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Integer prime : primes) {
                    writer.write(prime + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Example usage
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        PrimeNumberCalculator calculator = new PrimeNumberCalculator();
        PrimeNumberCalculatorTest writer = new PrimeNumberCalculatorTest();

        int maxNumber = 10000; // Example max number
        List<Integer> primes = calculator.calculatePrimes(maxNumber);

        String filename = "primes.txt";
        CompletableFuture<Void> writeFuture = writer.writePrimesToFileAsync(primes, filename);

        // Wait for completion of the write operation (optional)
        writeFuture.get();
        System.out.println("Prime numbers written to " + filename + " successfully.");
    }
}

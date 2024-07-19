package com.example.Array;

import java.util.*;

public class ArrayUtilsTest {

    // Generic method to swap elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swapping (Integer): " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("After swapping (Integer): " + Arrays.toString(intArray));

        // Example with String array
        String[] strArray = {"apple", "banana", "cherry"};
        System.out.println("Before swapping (String): " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After swapping (String): " + Arrays.toString(strArray));

        // Example with custom object array
        Person[] personArray = {
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 20)
        };
        System.out.println("Before swapping (Person): " + Arrays.toString(personArray));
        swap(personArray, 0, 2);
        System.out.println("After swapping (Person): " + Arrays.toString(personArray));
    }

    // Example class for custom objects
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
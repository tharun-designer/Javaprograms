package com.example.reflection;
import com.example.reflection.*;
import java.lang.reflect.*;
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Create an instance of ExampleClass
    	Reflection instance = new Reflection("Initial Value");

        // Get the Class object corresponding to ExampleClass
        Class<?> clazz = instance.getClass();

        // Get the private field "privateField" from the class object
        Field privateField = clazz.getDeclaredField("privateField");

        // Set accessible to true so we can modify private fields
        privateField.setAccessible(true);

        // Modify the private field
        privateField.set(instance, "Modified Value");

        // Verify the change by accessing the private field again
        String fieldValue = (String) privateField.get(instance);
        System.out.println("New value of privateField: " + fieldValue);
    }
}

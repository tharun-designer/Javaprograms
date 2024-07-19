package com.example.reflection;

public class Reflection {
	   private String privateField;

	    public Reflection(String privateField) {
	        this.privateField = privateField;
	    }

	    private void privateMethod() {
	        System.out.println("Private Method invoked");
	    }
	}


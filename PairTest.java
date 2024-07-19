package com.example.Pair;
import com.example.Pair.*;
public class PairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Pair<Integer, String> pair = new Pair<>(1, "One");

	        System.out.println("Original Pair: " + pair);
	        
	        Pair<String, Integer> reversedPair = pair.reverse();
	        System.out.println("Reversed Pair: " + reversedPair);
	    }
	}



package com.soft;

public class FactorialTest {

	public int findfactorial(int number) {
		
		int fact = 1;
		
		for(int i=1;i<=number;i++) {
			fact = fact*i;
		}
		return fact;
		
	}
	
	
}

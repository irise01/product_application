package com.soft;
import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class ProductManagmentApplicationTests {

	
	  public static void beforeclass() {
	  System.out.println("before test classs."); 
	  
	  }
	 
	

	  @BeforeAll 
	  public static void beforeMethodTest() {
	  System.out.println("before test all test cases.."); 
	  }
	 
	
	@Test
	public void testfact_1() {
		
		FactorialTest factExample = new FactorialTest();
		
		int expectedResult = 120;
		System.out.println("test case fact 1 execution");
		
		int actualtresult = factExample.findfactorial(5);
		
		assertThat(actualtresult).isEqualTo(expectedResult);
	}
	
	@Test
	public void testfact_2() {
		
		FactorialTest factExample = new FactorialTest();
		
		int expectedResult = 120;
		System.out.println("test case fact 2 execution");
		
		int actualtresult = factExample.findfactorial(5);
		
		assertThat(actualtresult).isEqualTo(expectedResult);
	}
	
	
	  @AfterAll 
	  public static void afterAllTest() {
	  System.out.println("after all test cases..."); 
	  
	  }
	 
	 
	

}

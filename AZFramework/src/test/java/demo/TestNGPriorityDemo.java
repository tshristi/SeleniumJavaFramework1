package demo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {

	@Test(priority=2)
	public void one() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void two() {
		System.out.println("I am inside Test 2");
	}
	
	@Test
	public void three() {
		System.out.println("I am inside Test 3");
	}
}

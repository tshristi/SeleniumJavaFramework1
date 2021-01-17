package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


@Test(enabled=false)
public class TestNGIgnoreDemo {
	
	
	@Test 
	//@Ignore
	public void test1() {
		System.out.println("Running Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Running Test 2");
	}
	
	
}

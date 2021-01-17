package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo2 {

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearch2() {
		//goto google.com
		driver.get("https://google.com");

		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	
	@Test
	public void googleSearch3() {
		//goto google.com
		driver.get("https://google.com");

		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		//driver.quit();
		System.out.println("Test completed successfully.");
	}
}

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest() {
		
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}

	@Test
	public void googleSearch() {
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
		
		PropertiesFile.setProperties();
	}
}

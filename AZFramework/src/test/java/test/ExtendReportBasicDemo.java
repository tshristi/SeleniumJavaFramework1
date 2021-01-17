package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("extentReports.html");
		extent.attachReporter(spark);

		ExtentTest test1 = extent.createTest("Google Search Test One","This is a test to validate google search funtionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("automation step by step");
		test1.pass("Entered text in Searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keboard entere key");
		
		driver.close();
		test1.pass("Closed the browser");
		
		test1.info("Test completed");
		
		//Fail
		
		ExtentTest test2 = extent.createTest("Google Search Test Two","This is a test to validate google search funtionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("automation step by step");
		test2.pass("Entered text in Searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keboard enter key");
		
		driver.close();
		test2.pass("Closed the browser");
		
		test2.info("Test completed");
		
		extent.flush();
	}

}

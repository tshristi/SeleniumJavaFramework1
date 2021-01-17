package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentSparkReporter spark;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("extent.html");
		extent.attachReporter(spark);
	}

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void test1() {

		ExtentTest test = extent.createTest("Google Search Test One","This is a test to validate google search funtionality");
		driver.get("https://google.com");
		test.pass("Navigate to google.com");

		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() {
		ExtentTest test = extent.createTest("Google Search Test One","This is a test to validate google search funtionality");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.pass("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		//driver.quit();
		System.out.println("Test completed successfully.");
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}

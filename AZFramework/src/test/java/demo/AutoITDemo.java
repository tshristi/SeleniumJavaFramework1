package demo;

//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {

	public static void main(String[] args) throws Exception {
		test();
	}
	public static void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://tinyupload.com/");
		
		Thread.sleep(5000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", driver.findElement(By.name("uploaded_file")).click();
		
		//driver.findElement(By.name("uploaded_file")).click();
		
		
		System.out.println("clicked");
		//driver.findElement(By.name("uploaded_file")).click();

		Runtime.getRuntime().exec("C:\\Users\\phxsu\\Documents\\FileUploadScript.exe");

		Thread.sleep(3000);

		//driver.close();
		
		//driver.findElements(By.id("browse button inspection")).sendKeys("file path");
	}
}

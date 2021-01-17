package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) {
		seleniumWaits();
	}

	public static void seleniumWaits() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Interview question -- 250 ms - Default frequency / poll time of implicit wait
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("ed sheeren perfect lyrics");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));		
		
		driver.findElement(By.name("abcd")).click();
		
		driver.close();
	}
}

//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

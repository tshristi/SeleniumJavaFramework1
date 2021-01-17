package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("abcd");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);


		//driver.findElement(By.linkText("ABCD Inc.")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.cssSelector("a[href*= 'http://www.smartstart.org/abcd-infographic/']"));
						//cssSelector("a[aria-label*='Page 2']"));
						//cssSelector("a[href*='https://www.youtube.com/watch']"));
						//cssSelector("a[ping*='/url?sa=t&source=web&rct']"));
						//className("fl"));
						
						//className("LC20lb DKV0Md"));
						//cssSelector("a[href*='https://abcdstud']"));
						//linkText("ABCD Study")); this won't work
						
						
						//cssSelector("a[href*='https://abcdstudy.org']"));
						//class("LC20lb DKV0Md"));
						//linkText("ABCD Inc."));

				if(linkElement.isEnabled()) {
					System.out.println("Element found");

				}
				return linkElement;
			}
		});

		element.click();





		Thread.sleep(10000);

		driver.close();
		driver.quit();

	}
}

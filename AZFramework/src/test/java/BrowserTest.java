import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println( "ProjectPath: "+projectPath);
		
		//FirefoxDriver
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//ChromeDriver
//		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//InternetExplorerDriver
//		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/IEDriver/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://selenium.dev/");
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hahah");
			
		}
		
		
		driver.close();
		driver.quit();
	}
}

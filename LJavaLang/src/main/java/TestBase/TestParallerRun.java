package TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestParallerRun {
	
	private static  WebDriver driver;
	
@Test(invocationCount=2)
		public void user_Navigate_to_LogIn_Page() throws Throwable {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
			//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
			}
	}



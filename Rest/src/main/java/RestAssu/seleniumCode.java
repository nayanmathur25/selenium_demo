package RestAssu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;

public class seleniumCode {
	
	WebDriver driver ;
	
	
	private static String encodeFileToBase64Binary(File file) throws Exception {
		FileInputStream fileInputStreamReader = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fileInputStreamReader.read(bytes);
		return new String(Base64.encodeBase64(bytes), "UTF-8");
	}
	
	@Test
	public void main() throws Exception
	{
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions co = new ChromeOptions();
	//WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), co);
	//WebDriver driver = new RemoteWebDriver(new URL("0.0.0.0:5920"));
	driver = new ChromeDriver();
	driver.get("https://www.google.com");
	driver.findElement(By.name("q")).sendKeys("cars");
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	for(int i=0;i<links.size();i++)
	{
		System.out.println(links.get(i).getAttribute("href"));
		if(links.get(i).getAttribute("href").contains("googlemenu"))
		{
			System.out.println("it is present");
		}
	}
	
	Thread.sleep(10000);
	
//	System.out.println(links.size());
//	Iterator<WebElement> it = links.iterator();
//	
//    
//    while(it.hasNext()){
//        
//        url = it.next().getAttribute("href");
//        
//        System.out.println(url);
//    }
	
	
//	WebDriver driver1 = new ChromeDriver();
//	driver1.get("https://www.facebook.com");
	
	
//	Thread.sleep(5000);	
//	((JavascriptExecutor)driver).executeScript("window.open()");
//	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//    driver.switchTo().window(tabs.get(1)); //switches to new tab
    
//    driver.switchTo().newWindow(WindowType.TAB);
//    driver.get("https://www.facebook.com");
//	Thread.sleep(5000);
	
		TakesScreenshot TSS = ((TakesScreenshot) driver);

		File file = TSS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target/screenshot/test.png"));

		File f = new File("target/screenshot/test.png");
		String encodstring = encodeFileToBase64Binary(f);
		//System.out.println(encodstring);
		
		//List<WebElement> links1 = new 
	

	}

//	@Test(priority=2)
//	public void main1() throws InterruptedException
//	{
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//	driver.get("https://www.facebook.com");
//	
//	
////	Thread.sleep(5000);	
////	((JavascriptExecutor)driver).executeScript("window.open()");
////	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
////    driver.switchTo().window(tabs.get(1)); //switches to new tab
//    
//    driver.switchTo().newWindow(WindowType.TAB);
//    driver.get("https://www.facebook.com");
//	Thread.sleep(5000);
//	driver.quit();
//	}




@AfterClass
public void Quit()
{
	driver.quit();
}

}

package TestCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumWebdriver {
	private static  WebDriver driver;	

	
	//@Test
	//@Given("^User is on Home Page$")
//	public void userison_homepage() throws IOException {
//
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
//		driver = new ChromeDriver();
//		driver.get("http://facebook.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
	
	@Test
	//@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		}
	
	@Test
	//@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.id("log")).sendKeys("testuser_1"); 	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	    driver.findElement(By.id("login")).click();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("Window.scrollBy(10,20)");
	    
	   		}
	@Test
	//@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login successfully");
		driver.quit();
	
	}		 

}

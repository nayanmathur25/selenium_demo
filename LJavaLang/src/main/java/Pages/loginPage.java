package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.LMAccess.LOCALGROUP_INFO_1;

import TestBase.TestBase;

public class loginPage extends TestBase{

	@FindBy(xpath = "//a[@href ='https://ui.freecrm.com']")
	WebElement loginlink;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement Calender;

	@FindBy(xpath="//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']")
	WebElement CRM;

	public loginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
public String login(String username1,String password1) throws InterruptedException
	{
	Thread.sleep(5000);
	loginlink.click();
	Thread.sleep(5000);
	username.sendKeys(username1);
	password.sendKeys(password1);
	loginButton.click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(Calender));
	Calender.click();
	Thread.sleep(5000);
	
	return driver.getCurrentUrl();
	
	}

public void selectValues() throws InterruptedException
{
	Thread.sleep(5000);
	CRM.click();
	Actions action = new Actions(driver);	
	WebElement elemnt = driver.findElement(By.xpath("//ul[@class='rd-navbar-nav']/li[3]/a"));
    action.moveToElement(elemnt).build().perform();
    List<WebElement> li = driver.findElements(By.xpath("//ul[@class='rd-navbar-dropdown rd-navbar-open-right']//a"));

	for(int i=0;i<=li.size();i++)
	{
		String x =li.get(i).getText();
		System.out.println(x);
		driver.findElement(By.linkText(x)).click();
		Thread.sleep(5000);
		WebElement y = driver.findElement(By.xpath("//ul[@class='rd-navbar-nav']/li[3]/a"));
	    action.moveToElement(y).build().perform();
	    Thread.sleep(5000);
	    li = driver.findElements(By.xpath("//ul[@class='rd-navbar-dropdown rd-navbar-open-right']//a"));
	    	  
	}	
	
}


}
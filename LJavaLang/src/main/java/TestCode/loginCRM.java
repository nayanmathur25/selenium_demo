package TestCode;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CalendarPage;
import Pages.loginPage;
import TestBase.TestBase;


public class loginCRM extends TestBase {

	public loginCRM() throws IOException
	{
		super();
	}

	loginPage log;
	CalendarPage CalendarP ;
	
	@BeforeTest
	public void initiazizeBrowser() throws IOException, InterruptedException
	{
		getinstance();
		log = new loginPage();
		CalendarP = new CalendarPage();
	}
	
	
	@Test
	public void verifyTitle() throws IOException 
	{
		driver.getTitle();
		Assert.assertEquals("CRM", driver.getTitle());
     }		

	@Test
	public void logincrm_function() throws IOException, InterruptedException 
	{
		//CalendarP = new CalendarPage();
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		log.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
		CalendarP.dropdown_Category("Optional");
		Thread.sleep(5000);
	}

}

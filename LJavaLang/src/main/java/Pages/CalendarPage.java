package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class CalendarPage extends TestBase{

	public CalendarPage() throws IOException {
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement NewButton_OnCalendar;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(name="category")
	WebElement catagory_link;
	
	
	public void dropdown_Category(String value) throws InterruptedException
	{
		String drpValue = "";
		NewButton_OnCalendar.click();
		Title.sendKeys("test");
		catagory_link.click();
		Thread.sleep(5000);
		List<WebElement> list =  driver.findElements(By.xpath("//div[@class='visible menu transition']"));
		for(int i=0;i<list.size();i++)
		{
			drpValue = list.get(i).getText();
			System.out.println(drpValue);
			
			
		}
		if(drpValue.contains(value))
		{
			System.out.println(drpValue +" is same as "+value);
			driver.findElement(By.xpath("//span[text()='"+value+"']")).click();
		}
		
		
	}

}

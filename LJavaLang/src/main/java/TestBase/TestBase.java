package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver;
	public static String browser;
	public static Properties prop;
	public static WebElement elment;
	
	public TestBase() throws IOException
	{
	    prop = new Properties();
		File file = new File("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		browser = prop.getProperty("Browser");
	}
	
	
	public static void getinstance() throws IOException, InterruptedException
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if(browser.equals("IE"))
		{
			System.out.println("IE present");
		}
	}
	
	public static void readExcel(String name) throws IOException {
		File f = new File("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet dataSheet = workbook.getSheetAt(0);

		int rows; // No of rows
		rows = dataSheet.getPhysicalNumberOfRows();
		//System.out.println(rows);
		for(int i=1;i<rows;i++)
		{
			Row row = dataSheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
			//Row[i][j] value = dataSheet.getRow(i).getCell(j);
				 name = row.getCell(j).getStringCellValue();
				 System.out.println(name);
			//System.out.print(row.getCell(j).getStringCellValue()+"|| ");  
			
			
		}
	}}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
	

}

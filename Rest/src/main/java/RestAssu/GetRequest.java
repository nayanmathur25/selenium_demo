package RestAssu;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GetRequest {
	
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriver driver;
	
	public static String GenerateString(String jsonPath) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(jsonPath)),"UTF-8");
	}

	@BeforeTest
	public void setExtent()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtendReport.html",true);
		extent.addSystemInfo("Environment","QA");
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
	{

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}
	
	
	@Test
	public void main() throws IOException {

		// https://petstore.swagger.io/v2/pet/findByStatus?status=available

		RestAssured.baseURI = "https://reqres.in";
		//https://reqres.in/api/users?page=2

		Response resp =	RestAssured.given().queryParam("page", 2)
				.when().get("/api/users")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().body("data[0].first_name", equalTo("Michael")).and().body("total_pages", equalTo(2))
				.extract().response();			
		
	System.out.println(resp.asString());
	

	
	JsonPath jp = ReusableMethod.JsonPaths(resp);
	
	
	System.out.println(jp.get("total"));
	
	String destination_addresses = jp.get("data[0].avatar").toString();
	System.out.println(destination_addresses);
	
	
	
//	RestAssured.given().contentType(ContentType.JSON).body(resp)
//	.when().post("/Users/nayan/Desktop/Folder/Json/testcopy.json")
//	.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
//	.extract().response();
	 

	}

}

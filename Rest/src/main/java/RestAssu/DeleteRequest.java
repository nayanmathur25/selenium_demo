package RestAssu;

import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:3000";

		
		for(int i=14;i<20;i++)
		{
			
		Response resp = RestAssured.given().
				when().delete("/about/"+i+"").then().assertThat().statusCode(200).
				extract().response();
				//System.out.println(resp.asString());
		}

	}

}

//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

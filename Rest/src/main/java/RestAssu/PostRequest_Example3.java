package RestAssu;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest_Example3 {
	
	// String that we going to use to post
	public String payloadData(String name ,String Department)
	{
		String postReq = "{\n" + 
				"    \"name\": \""+name+"\",\n" + 
				"    \"department\": \""+Department+"\",\n" + 
				"    \"college\": \"Indian Institute of Engineering Science and Technology, Shibpur\"\n" + 
				"  }";
		return postReq;
	}
	
	// dataprovider will use to post multiple data
	@org.testng.annotations.DataProvider(name="Info")
	public Object DataProvider()
	{
		return new Object[][] {{"Nayan","IT"},{"Vidya","Bio"},{"Manoj","HR"}};
		
	}

	// you have to pass the same number of parameter that you have created in dataprovider , pass the same in the body
	@Test(dataProvider = "Info")
	public void postmethod(String name , String dep) {	
		
		RestAssured.baseURI = "http://localhost:3000";

		//make sure to put header("Content-Type", "application/json")
		Response resp = 
				RestAssured.given().header("Content-Type", "application/json").body(payloadData(name,dep))
				.when().post("/about")
				.then().assertThat().statusCode(201)
				.extract().response();

		// calling a reusable methods which will return json path
		JsonPath j = ReusableMethod.JsonPaths(resp);
		
		//String CreatedAt = jp.get("name");
		System.out.println(j.get("name")+"   "+j.get("department"));

	}

}

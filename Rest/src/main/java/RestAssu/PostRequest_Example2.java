package RestAssu;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest_Example2 {
	
	
	public String payloadData(String name ,String Department)
	{
		String postReq = "{\n" + 
				"    \"name\": \""+name+"\",\n" + 
				"    \"department\": \""+Department+"\",\n" + 
				"    \"college\": \"Indian Institute of Engineering Science and Technology, Shibpur\"\n" + 
				"  }";
		return postReq;
	}
	
	
	String complexjson = "{\n" + 
			"  \"destination_addresses\": [\n" + 
			"    \"Philadelphia, PA, USA\"\n" + 
			"  ],\n" + 
			"  \"origin_addresses\": [\n" + 
			"    \"New York, NY, USA\"\n" + 
			"  ],\n" + 
			"  \"rows\": [{\n" + 
			"    \"elements\": [{\n" + 
			"      \"distance\": {\n" + 
			"        \"text\": \"94.6 mi\",\n" + 
			"        \"value\": 152193\n" + 
			"      },\n" + 
			"      \"duration\": {\n" + 
			"        \"text\": \"1 hour 44 mins\",\n" + 
			"        \"value\": 6227\n" + 
			"      },\n" + 
			"      \"status\": \"OK\"\n" + 
			"    }]\n" + 
			"  }],\n" + 
			"  \"status\": \"OK\"\n" + 
			"}";

	@Test
	public void postmethod() {	
		
		RestAssured.baseURI = "http://localhost:3000";

		//make sure to put header("Content-Type", "application/json")
		Response resp = 
				RestAssured.given().header("Content-Type", "application/json").body(complexjson)
				.when().post("/about")
				.then().assertThat().statusCode(201)
				.extract().response();

		// calling a reusable methods which will return json path
		JsonPath j = ReusableMethod.JsonPaths(resp);
		
		//String CreatedAt = jp.get("name");
		System.out.println(j.get("name")+"   "+j.get("department"));

	}

}

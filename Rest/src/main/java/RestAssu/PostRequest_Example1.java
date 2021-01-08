package RestAssu;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
import io.restassured.response.Response;

public class PostRequest_Example1 {
	
	public String payloadData(String name ,String Department)
	{
		String postReq = "{\n" + 
				"    \"name\": \""+name+"\",\n" + 
				"    \"department\": \""+Department+"\",\n" + 
				"    \"college\": \"Indian Institute of Engineering Science and Technology, Shibpur\"\n" + 
				"  }";
		return postReq;
	}

	@Test(priority = 1)
	public void postmethod() {	
		
//		convert json to string : Eclipse>preference>java>editor>typing and select the "escape text when passing to literal"
//		So when you past the json string it will automatically convert
		String postReq = "{\n" + 
				"    \"name\": \"Nayan Agarwal\",\n" + 
				"    \"department\": \"Information Technology\",\n" + 
				"    \"college\": \"Indian Institute of Engineering Science and Technology, Shibpur\"\n" + 
				"  }";
		
		RestAssured.baseURI = "http://localhost:3000";

		//make sure to put header("Content-Type", "application/json")
		Response resp = 
				RestAssured.given().header("Content-Type", "application/json").body(payloadData("Salman","kv2"))
				.when().post("/about")
				.then().assertThat().statusCode(201)
				.extract().response();
		
		//whenever you extract the response from post it will always be in raw format and you convert it into the string
		String respValue  = resp.asString();
		System.out.println(respValue);
		
		//to extract the specific value from the response you have to convert it into JSON
		JsonPath jp = new JsonPath(respValue);
		
		//String CreatedAt = jp.get("name");
		System.out.println(jp.get("name")+"   "+jp.get("department"));

	}
	
}

package RestAssu;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

public class GetRequest_JsonServer_Example1 {
	
	public static void splitArray(String value) {
		String remove = value.replace("[", "").replace("]", "");
		String[] split = remove.split(",");

		for (int i = 0; i < split.length; i++) {

			System.out.println(split[i]);
			System.out.println();
		}
	}

	public static void fecthObject(String value) {
		String remove = value.replace("{", "").replace("}", "");
		String[] split = remove.split(",");

		for (int i = 0; i < split.length; i++) {

			System.out.println(split[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
	
		RestAssured.baseURI = "http://localhost:3000";
		
		Response resp = RestAssured.given().
		when().get("/about").
		then().assertThat().statusCode(200).//body("[0].department",equalTo("Information Technology")).
		extract().response();
		//System.out.println(resp.asString());
		
		JsonPath jp = ReusableMethod.JsonPaths(resp);
				
		String destination_addresses = jp.get("[2].destination_addresses").toString();
		System.out.println(destination_addresses);
		
		String origin_addresses = jp.get("[2].origin_addresses").toString();
		System.out.println(origin_addresses);
		
		String row_distance = jp.get("[2].rows[0].distance").toString();
		System.out.println(row_distance);
		
		String row_duraction = jp.get("[2].rows[0].duration").toString();
		System.out.println(row_duraction);
		
		fecthObject(row_distance);
		fecthObject(row_duraction);		
		//splitArray(destination_addresses);
		//splitArray(origin_addresses);	
		

	}

}

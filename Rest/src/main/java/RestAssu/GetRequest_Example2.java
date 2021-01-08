package RestAssu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest_Example2 {
	
	
	//this method will be used if you have a json in a file and you want to fetch the value from that
	public static String GenerateString(String jsonPath) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(jsonPath)));
	}
	
	@Test
	public void StaticJson() throws IOException
	{
		String respo = GenerateString("/Users/nayan/Desktop/Json/test.json");
		//System.out.println(respo);
		JsonPath jp = new JsonPath(respo);
		System.out.println(jp.get("about"));
	
		
		System.out.println(jp.get("about[1].name"));
	
		
		String destination_addresses = jp.get("about[2].destination_addresses").toString();
		System.out.println(destination_addresses);
		
		String origin_addresses = jp.get("about[2].origin_addresses").toString();
		System.out.println(origin_addresses);
		
		String row_distance = jp.get("about[2].rows[0].elements[0].distance").toString();
		System.out.println(row_distance);
		
		String row_duraction = jp.get("about[2].rows[0].elements[0].duration").toString();
		System.out.println(row_duraction);

		
		
		
	}

}

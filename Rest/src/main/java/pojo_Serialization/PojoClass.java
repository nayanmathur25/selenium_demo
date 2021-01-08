package pojo_Serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PojoClass {
	
	public static String GenerateString(String jsonPath) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(jsonPath)));
	}

	public static void main(String[] args) throws IOException {

		String respo = GenerateString("/Users/nayan/Desktop/Json/test.json");
		JsonPath jp = new JsonPath(respo);
		//System.out.println(jp.get("about[2].destination_addresses"));

		about x = RestAssured.given().baseUri("http://localhost:3000").expect().defaultParser(Parser.JSON).when()
				.get("/about/20").as(about.class);
		
		
		List<Rows> ls = x.getRows();
		for(int i=0;i<=ls.size();i++)
		{
			System.out.println(x.getRows().get(0).getDuration().get(i).getText());
			System.out.println(x.getRows().get(0).getDuration().get(i).getValue());
		}

	
	}
}

package RestAssu;

import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;



public class GetRequest_XML_Example1 {
	
	//convert XML to bytes to POST it
	public static String GenerateString(String xmlpath) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(xmlpath)));
	}

	public static void main(String[] args) throws IOException {
	
		//provide the file name of XML and store it in a string
		String respo = GenerateString("/Users/nayan/Desktop/Json/test.xml");
		
		
		//Post : it wil not work the api doesn't exist but way is right
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.given().queryParam("keys","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMf5Y").body(respo).
		when().post("/maps/api/place/add/xml").then().statusCode(200).
		extract().response();
		
		//Get
		
		RestAssured.baseURI = "https://www.google.com";
		Response re = RestAssured.given().
		when().get("/sitemap.xml").then().statusCode(200).
		extract().response();
		
		//response will always be in a raw formate so convert it into s
		String res = re.asString();
		//System.out.println(res);
		
		//to fetch the xml value use XMlPath
		XmlPath xp = new XmlPath(res);
		for(int i=0;i<20;i++)
		{
			System.out.println(xp.get("sitemapindex xmlns.sitemap["+i+"].loc"));
		}
		


	}

}

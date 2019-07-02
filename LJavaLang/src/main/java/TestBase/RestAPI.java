package TestBase;



import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.deps.com.thoughtworks.xstream.io.binary.Token.Attribute;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;



public class RestAPI   {

       
	 @Test
	 public void GetWeatherDetails() throws ParseException, IOException
	 {   
		 
		 
	  //Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather";

	 String resp = RestAssured.given().param("q","London").param("appid", "b6907d289e10d714a6e88b30761fae22").when().get().then().extract().asString();
	 //System.out.println(resp);
	 
	 
	 JSONParser parse = new JSONParser(); 


	  JSONObject jobj = (JSONObject)parse.parse(resp); 
	  System.out.println(jobj);

	  
	  Object ob =  jobj.get("weather");
	  
      String s = ob.toString().replace("[", "").replace("]", "");        
      s  = s.substring(1, s.length()-1);
      System.out.println(s);
      
      String[] keyValuePairs = s.split(",");              //split the string to creat key-value pairs
      Map<String,String> map1 = new HashMap<>(); 

      for(String pair : keyValuePairs)                        //iterate over the pairs
      {
          String[] entry = pair.split(":");                   //split the pairs to get key and value 
          map1.put(entry[0].trim(), entry[1].trim()); 		//add them to the hashmap and trim whitespaces
          //System.out.println(map1.values());			
          
      } 
      
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet("Restapi");
      
      ArrayList<String> ar1 = new ArrayList<String>(map1.values());
      Row row = null;
      row = sheet.createRow(0);
      
      for(int i=0;i<ar1.size();i++)
      {
    	  System.out.println(ar1.get(i));
    	  
    	  row.createCell(i).setCellValue(ar1.get(i));
       
      }
	  
      FileOutputStream outputStream = new FileOutputStream("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
	  workbook.write(outputStream);               
      outputStream.close(); 
	  
	 
	 ValidatableResponse res =  RestAssured.given().param("q","London").param("appid", "b6907d289e10d714a6e88b30761fae22").when().get().then();
	 Object country = res.extract().response().path("weather.description");
	 //System.out.println(country);
	 
	 Object weather = res.extract().response().path("main.temp");
	// System.out.println(weather);
	 
	 Object jasonp = jobj.get("visibility");
	// System.out.println(jasonp);
	
        
         
     int statuscode = RestAssured.given().get().getStatusCode();
     System.out.println(statuscode);

	 
	 }

 }


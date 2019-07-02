package TestBase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Restapitest {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
        try (FileReader reader = new FileReader("/Users/nayanmathur/git/repository/LJavaLang/test.json"))
        {
            //Read JSON file
        	
        	JSONParser jsonParser = new JSONParser();
   
        	JSONObject obj=(JSONObject)JSONValue.parse(reader);
        	System.out.println(obj.toString());
        	       	
        	//To fetch the single value from jason Object not jason array
        	Object base = (Object) obj.get("coord");
            System.out.println(base);
        	
        	// to read the data from json object 
        	ObjectMapper mapper = new ObjectMapper();
        	Map map = mapper.readValue(obj.toString(), Map.class);
   
//        	Iterator<Map.Entry> itr = map.entrySet().iterator(); 
//            while (itr.hasNext()) { 
//                Map.Entry pair = itr.next(); 
//                System.out.println(pair.getKey() + " : " + pair.getValue()); 
//            } 
            
            System.out.println(map.keySet().toArray()[0]+"   "+map.values().toArray()[0]);  //to get the specific value
            
            String s1 = obj.toString();
            String s3 = s1.replace("{", "").replace("[", "").replace("]", "").replace("}", "");
            String [] s2 = s3.split(",");
            
            
            HashMap<String,String> hm = new LinkedHashMap<String,String>();
 
                     
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Restapi");
            Row row = null;
            row = sheet.createRow(0);
            
            for(int i=0;i<s2.length;i++)
            {
         
            	row.createCell(i).setCellValue(s2[i]);
            }
            
	  
            FileOutputStream outputStream = new FileOutputStream("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
      	  	workbook.write(outputStream);               
            outputStream.close(); 

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 

	}

}

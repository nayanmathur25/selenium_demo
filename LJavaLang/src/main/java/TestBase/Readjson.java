package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readjson {
	
	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet sheet;
	
	
	public static void readjson(String JsonArrayvalue,int rowgetkey,int rowgetValue) throws IOException, ParseException
	{
		
		JSONParser parse = new JSONParser(); 
		FileReader reader = new FileReader("/Users/nayanmathur/git/repository/LJavaLang/test.json");
		JSONObject obj = (JSONObject) parse.parse(reader);
        System.out.println(obj);
        
        Object ob1 =  obj.get("dt");
        Object ob2 =  obj.get("visibility");
        System.out.println(ob2);
        System.out.println(ob1);
 
        Object ob =  obj.get(JsonArrayvalue);

        String s = ob.toString().replace("[", "").replace("]", "");        
        s  = s.substring(1, s.length()-1);
        //System.out.println(s);

        String[] keyValuePairs = s.split(",");              //split the string to creat key-value pairs
        Map<String,String> map1 = new HashMap<>(); 

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split(":");                   //split the pairs to get key and value 
            map1.put(entry[0], entry[1]);          //add them to the hashmap and trim whitespaces
            
            System.out.println(entry[0]+" === "+entry[1]);
            

        } 
        
        // workbook = new XSSFWorkbook();
        
        
        Row row = null;
        
        List<String> keys = new ArrayList<String>(map1.keySet());			//converting hashmap to arraylist for keyset
        ArrayList<String> valueList = new ArrayList<String>(map1.values());	//converting hashmap to arraylist for keyvalues

        
        	row = sheet.createRow(rowgetkey);
       	 for(int k=0;k<keys.size();k++)
            {

       		 row.createCell(k).setCellValue(keys.get(k));
            }
       	 
       	 row = sheet.createRow(rowgetValue); 
       	 for(int j=0;j<valueList.size();j++)
            {
           	 
           	 //System.out.println(valueList.get(j));
           	 row.createCell(j).setCellValue(valueList.get(j)); 
            }
       	 
         
         
	}
	
	
	
	
public static void main(String[] args) throws IOException, ParseException
{
	sheet = workbook.createSheet("sheet5");
	readjson("coord",0,1);
	//readjson("weather",2,3);
	//readjson("main",4,5);
	//readjson("sys",6,7);
	//readjson("dt",6,7);
	
	
	
	FileOutputStream outputStream = new FileOutputStream("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
	workbook.write(outputStream);               
    outputStream.close(); 
	
	
//	
//	 JSONParser parse = new JSONParser(); 
//	
//	 FileReader reader = new FileReader("/Users/nayanmathur/git/repository/LJavaLang/test.json");
//     
//         //Read JSON file
//    	 
//    	 XSSFWorkbook workbook = new XSSFWorkbook();
//    	 FileOutputStream out = new FileOutputStream( new File("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx"));
//         XSSFSheet sheet = workbook.createSheet("sheet5");
//    	 
//         JSONObject obj = (JSONObject) parse.parse(reader);
//         System.out.println(obj);
//  
//         Object ob =  obj.get("main");
// 
//         String s = ob.toString().replace("[", "").replace("]", "");        
//         s  = s.substring(1, s.length()-1);
//         System.out.println(s);
//
//         String[] keyValuePairs = s.split(",");              //split the string to creat key-value pairs
//         Map<String,String> map1 = new HashMap<>(); 
// 
//         for(String pair : keyValuePairs)                        //iterate over the pairs
//         {
//             String[] entry = pair.split(":");                   //split the pairs to get key and value 
//             map1.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
//             
//         }  
//         
//         Row row = null;
//         
//         List<String> keys = new ArrayList<String>(map1.keySet());
//      
//         ArrayList<String> valueList = new ArrayList<String>(map1.values());
//
//         
//         	row = sheet.createRow(0);
//        	 for(int k=0;k<keys.size();k++)
//             {
// 
//        		 row.createCell(k).setCellValue(keys.get(k));
//             }
//        	 
//        	 row = sheet.createRow(1); 
//        	 for(int j=0;j<valueList.size();j++)
//             {
//            	 
//            	 System.out.println(valueList.get(j));
//            	 row.createCell(j).setCellValue(valueList.get(j)); 
//             }
//        	 
//                
//             FileOutputStream outputStream = new FileOutputStream("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
//       	 	 workbook.write(outputStream);               
//             outputStream.close(); 
//             
//        }
       

 }
}


package TestBase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		XSSFWorkbook workbook1 = null ;
     	workbook1 = new XSSFWorkbook();
	 	XSSFSheet sheet = workbook1.createSheet("sheet3");
	 	XSSFRow row;
        int rownum = 1;
        row = sheet.createRow(rownum);
	 	 
	 	
	 	for(int i=0;i<4;i++)
	 	{
	 		 
	 		
             row.createCell(i).setCellValue("test"+i); 
             System.out.println("pass"+i);
	 	}
	 	
	 	
	 	FileOutputStream outputStream = new FileOutputStream("/Users/nayanmathur/git/repository/LJavaLang/src/main/java/readExl.xlsx");
	 	workbook1.write(outputStream);
	 	outputStream.close();  
	 	

	}
	
	

}

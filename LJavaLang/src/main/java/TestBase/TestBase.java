package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class TestBase {
	private static WebDriver driver;
	
	public static void readExcel() throws IOException {
		File f = new File("/Volumes/Extra/ECLIPSE/LJavaLang/src/main/java/readExl.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet dataSheet = workbook.getSheetAt(0);

		int rows; // No of rows
		rows = dataSheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		for(int i=1;i<rows;i++)
		{
			Row value = dataSheet.getRow(i);
			
			System.out.println(value.getCell(i));
		}
	}
	public static void main(String[]args) throws IOException
	
	{	
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("JAVA");
		ar.add("python");
		ar.add("abc");
		//HashSet<String> list = new HashSet<String>(ar);
		//System.out.println(list);
		//Collections.reverse(ar);
		//System.out.println(ar);
		
		
		int[] a = {1,2,3};
		int[] b = {1,2,6};
		
		for(int i=0;i<=a.length;i++)
		{
			//System.out.println(a[i]);
			for(int j=i;j<=b.length;j++)
			{
				//System.out.println(b[j]);
				if(i!=j)
				{
					System.out.println(b[j]);
				}
			}
			
		}
		
		
		
		
		
		
		//readExcel();
	}

}

package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.google.common.io.FileBackedOutputStream;

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		
		File loc=new File("C:\\Users\\God\\eclipse-workspace\\SeleniumProject\\src\\test\\resources\\Book1.excel.xlsx");
	
	FileInputStream fi=new FileInputStream(loc);
	
	Workbook w=new XSSFWorkbook(fi);
	
		Sheet s = w.getSheet("sheet1");
		
		Row row = s.getRow(2);
		
		Cell cell = row.getCell(3);
		System.out.println(cell);
		
		/*WebElement e=null;
		e.sendKeys(cell.toString());*/
		
		int rowcounts = s.getPhysicalNumberOfRows();
		System.out.println(rowcounts);
		
		int cellcounts = row.getPhysicalNumberOfCells();
		System.out.println(cellcounts);
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			Row row2 = s.getRow(i);
			for(int j=0;j<row2.getPhysicalNumberOfCells();j++) {
				Cell cell2 = row2.getCell(j);
				/*int alltype = cell2.getCellType();
				
				 System.out.println(alltype);*/
				 
				int type = cell.getCellType();
				// System.out.println(type);
		
		if(type==1) {
			String value = cell.getStringCellValue();
			System.out.println(value);	
		}
		if(DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat si=new SimpleDateFormat("dd/MMM/yyyy"); 
			String value = si.format(date);
			System.out.println(value);
		}
		else {
			double db = cell.getNumericCellValue();
			long l=(long) db;
			 String value = String.valueOf(l);
			 System.out.println(value);
			 		}
		
		 
		
			}
		} 
	}

}

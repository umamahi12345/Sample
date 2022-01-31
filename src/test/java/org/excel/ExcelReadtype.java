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

public class ExcelReadtype {
	
	public static void main(String[] args) throws IOException {
		 
		File loc=new File("C:\\Users\\God\\eclipse-workspace\\SeleniumProject\\src\\test\\resources\\Book1.excel.xlsx");
	
	FileInputStream fi=new FileInputStream(loc);
	
	Workbook w=new XSSFWorkbook(fi);
		Sheet s= w.getSheet("sheet1");		 
		Row row = s.getRow(2);
		Cell cell = row.getCell(2);
		System.out.println(cell);
		
		// 1---string(name)
		//0----number,date
		int type = cell.getCellType();
		System.out.println(type);
		
		if(type==1) {
			String value = cell.getStringCellValue();
			System.out.println(value);	
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat si=new SimpleDateFormat(); 
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

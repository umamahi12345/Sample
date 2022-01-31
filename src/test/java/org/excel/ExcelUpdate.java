package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {
	public static void main(String[] args) throws IOException {
		File loc=new File("C:\\Users\\God\\eclipse-workspace\\SeleniumProject\\src\\test\\resources\\Book1.excel.xlsx");
	
	FileInputStream fi=new FileInputStream(loc);		
		Workbook w=new XSSFWorkbook(fi);
		Sheet s = w.getSheet("sheet1");
		Row row = s.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		if(value.equals("mani")) {
			cell.setCellValue("chitra");
		}
		 System.out.println(cell);
		 
		FileOutputStream fo=new FileOutputStream(loc);
		w.write(fo);
		
	}
	

}

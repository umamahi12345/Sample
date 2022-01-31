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

public class Excelwrite {
	
	public static void main(String[] args) throws IOException {
		
		File loc=new File("C:\\Users\\God\\eclipse-workspace\\SeleniumProject\\src\\test\\resources\\Book1.excel.xlsx");
		/*
		Workbook w=new XSSFWorkbook();
		Sheet s = w.createSheet("sheet1");
		Row row = s.createRow(2);
		Cell cell = row.createCell(0);
		cell.setCellValue("umamani");
		System.out.println(cell);
		*/
		
		//Existing excel
		
		FileInputStream fi=new FileInputStream(loc);//to get sheet from this excel
		
		Workbook w=new XSSFWorkbook();
		Sheet s = w.getSheet("sheet1");
		Row row = s.getRow(2);
		Cell cell = row.getCell(0);
		cell.setCellValue("umamani");
		System.out.println(cell);
		
		FileOutputStream fo=new FileOutputStream(loc);
		w.write(fo);
		System.out.println("completed----");
		
	}

	
	 
}

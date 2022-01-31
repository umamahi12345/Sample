package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	//browserlaunch
	/*private WebDriver browserlaunch() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		return driver;*/
	
	public static WebDriver browserlaunch(String browsername) {
		/*if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		 }
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;*/
		switch(browsername) {
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
		case "firefox":
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    break;
	    
		case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
		default:
			break;
				}
		return driver;

	}
//Url launch
	public static void launchUrl(String url) {
		driver.get(url);
	}
	//Maximize
	public static void maximize() {
	driver.manage().window().maximize();
	}
//Implicit wait
	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
 //current url
	public static String currentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}
//Title
	public static String title() {
		String title = driver.getTitle();
		return title;
	}
//quit
	public static void quit() {
		driver.quit();
	}
	//sendkeys
	public static void sendkeys(WebElement e,String name) {
	 e.sendKeys(name);	
	}
	//click
	public static void click(WebElement e) {
		e.click();
		}
	//getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	//getAttributes
	public static String getAttributes(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	//Actions
	//movetoelement
	public static void movetoelement(WebElement e) {
		 Actions a=new Actions(driver);
		 a.moveToElement(e).perform();
	}
	//draganddrop
	public static void draganddrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	//Select
	//selectbyindex
	public static void selectByindex(WebElement e,int index) {
		 Select s=new Select(e);
		 s.selectByIndex(index);
		 	}
	//selectbyvalue
	public static void selectbyvalue(WebElement e,String value) {
		 Select s=new Select(e);
		 s.selectByValue(value);
	}
//findelement
	public static WebElement findelements(String locator,String locatorname) {
		WebElement e=null;
		if(locator.equals("id")) {
			e = driver.findElement(By.id(locatorname));
		}
		else if(locator.equals("name")) {
			e = driver.findElement(By.name(locatorname));
		}
		else if(locator.equals("xpath")) {
			e=driver.findElement(By.xpath(locatorname));
		}
		return e;
	}
	
	//selectByvisibletext	
	public static void selectByvisibletext(WebElement e,String text) {
				Select s=new Select(e);
				s.selectByVisibleText(text);
			 }
//getoptions
	public static int getoptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		return size;
		 				 
	}
//deselectbyindex
	public static void deselectbyindex(WebElement e,int index) {
		 Select s=new Select(e);
		 s.deselectByIndex(index);

}
	//deselectbyvalue
	public static void deselectbyvalue(WebElement e,String name1) {
		Select s=new Select(e);
		s.deselectByValue(name1);
		 	}
	
//deselectbyvisibletext
	public static void deselectByvisibleText(WebElement e,String text1) {
		 Select s=new Select(e); 
		 s.deselectByVisibleText(text1);
	}
//deselectall
	public static void deselectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	
//ismultiple---single or multiple
	public static boolean ismultiple(WebElement e) {
		Select s=new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
		 	}
	
//getAllselectedoptions
	public static List<WebElement> getAllselectedOptions(WebElement e) {
		Select s=new Select(e);
List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
for(int i=0;i>allSelectedOptions.size();i++) {
	WebElement allops = allSelectedOptions.get(i);
	String text = allops.getText();
}
return allSelectedOptions;
	}
	
	//getfirstselectedoptions
	public static String getfirstSelectedoptions(WebElement e) {
		Select s=new Select(e);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
		
	}
//ALERT
	//accept
	public static String accept() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
	}
//dismiss
	public static String dismiss() {
		Alert alert = driver.switchTo().alert();
		String text1 = alert.getText();
		alert.dismiss();
		return text1;
	}
//ACTIONS
	//contextclick
	public static void contextclick(WebElement name2) {
		Actions a=new Actions(driver);
		a.contextClick(name2).perform();
	}
//doubleclick
	public static void doubleclick(WebElement name3) {
		Actions a=new Actions(driver);
		a.doubleClick(name3).perform();
	}
//clickandHold & Release
	public static void clickandHold(WebElement src1,WebElement des1) {
		 Actions a=new Actions(driver);
		 a.clickAndHold(src1).release(des1).perform();
			}
		
//Javascript
//jssetAttribute
	public static void js(WebElement e,String name) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setattributes('value','"+name+"')", e);
	}
//JsgetAttribute
	public static String jsgetAttribute(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 Object obj = js.executeScript("return arguments[0].getattributes('value')",e);
		 String str = obj.toString();
		return str;
	}
	
	//Scrolldown
	public static void scrolldown(WebElement e,String text3) {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(text3)", e);

	}
//Scrollup
	public static void Scrollup(WebElement e,String text4) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(text4)", e);
			
	}
//ROBOT
	//clear
	public static void clear(WebElement e) {
		e.clear();
	}
//excel	
	public static String getexcel(String filename,String sheetName,int rowNo,int cellNo) throws IOException {
		
		File loc=new File("C:\\Users\\God\\eclipse-workspace\\SeleniumProject\\src\\test\\resources\\"+filename+".xlsx");		
		FileInputStream fi=new FileInputStream(loc);	
		Workbook w=new XSSFWorkbook(fi);					
			Sheet s = w.getSheet(sheetName);						
			Row row = s.getRow(rowNo);			
			Cell cell = row.getCell(cellNo);	 
			
			int type = cell.getCellType();
			String value = null; 	
	if(type==1) {
		 value = cell.getStringCellValue();		 
	}
	if(DateUtil.isCellDateFormatted(cell)) {
		Date date = cell.getDateCellValue();
		SimpleDateFormat si=new SimpleDateFormat("dd/MMM/yyyy"); 
		 value = si.format(date);		 
	}
	else {
		double db = cell.getNumericCellValue();
		long l=(long) db;
		 value = String.valueOf(l);		  
		 		}	
	return value;
	
	}
	
	
	
	
}

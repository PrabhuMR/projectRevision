package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
  public static WebDriver driver;
  
 public static WebDriver chromeDriver() {
	WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	return driver;
}
 
 public static WebDriver browserlunch(String browsername) {
	 if(browsername.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
	 }
	 else if(browsername.equalsIgnoreCase("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
	 }
	return driver;
 }
 
 public static void urlLunch(String url) {
	 driver.get(url);
	 driver.manage().window().maximize();
}
 
public static void implicityWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
} 

public  static void sendkeys(WebElement e,String value) {
   e.sendKeys(value);
	
   } 
 
 public static void btnclick(WebElement e) {
    e.click();
}
 
 public static void quit(){
    driver.quit();
}
 
 public static String getCurrentUrl() {
	
	//	String Url = driver.getCurrentUrl();
    //	return Url;
	 
	return driver.getCurrentUrl();
	
	}
 
 public static String getTitle() {
       return driver.getTitle();
}
 
 public static String getAttribute(WebElement e) {
   return e.getAttribute("value");
}
 
 public static void moveToElement(WebElement target) {
    Actions a=new Actions(driver);
    a.moveToElement(target).perform();
} 
 
 public static void dragAndDrop(WebElement source,WebElement target) {
    Actions a=new Actions(driver);
    a.dragAndDrop(source, target).perform();
}
 
 public static void selectByIndex(WebElement element, int index) {
    Select s =new Select(element);
    s.selectByIndex(index);
}
 public static WebElement findElement(String locatorName, String locName) {
	 
	 WebElement e=null;
    if (locatorName.equals("id")) {
	e= driver.findElement(By.id(locName));
	}else if (locatorName.equals("name")) {
		e= driver.findElement(By.name(locName));

	}else if (locatorName.equals(locName)) {
		e= driver.findElement(By.xpath(locName));

	}
	return e;
}
 
public static String getExcelData(String filename, String sheetname ,int rowno,int cellno) throws IOException {
	File location=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\"+filename+".xlsx");
//	File location=new File("D:\\java_workspace\\Maven\\src\\test\\resources\\data.xlsx");
    FileInputStream	st=new FileInputStream(location);
	Workbook w=new	XSSFWorkbook(st);
	Sheet sheet = w.getSheet(sheetname);
	Row row = sheet.getRow(rowno);
	Cell cell = row.getCell(cellno);
	int Type = cell.getCellType();	
//  type-1 string
//  type-0 number
		String value= null;
	if (Type==1) {
		 value = cell.getStringCellValue();
		}
	else {
		double db = cell.getNumericCellValue();
//		type casting
		long ln= (long)db;
		 value = String.valueOf((long)cell.getNumericCellValue());
		}
	return value;	
		
	}









}
 
 
 
 
 
 
 
 
 
 
 
 
 
 


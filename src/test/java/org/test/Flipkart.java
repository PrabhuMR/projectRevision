package org.test;

import java.util.Date;
import java.util.List;

import org.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class Flipkart extends BaseClass {
	@BeforeClass
	private void beforeclass() {
         browserlunch("chrome");
         implicityWait(20);
        
	}
	@AfterClass
	private void afterclass() {
           quit();
	}
	@BeforeMethod
	private void beforemethod() {
          Date d=new Date();
          System.out.println("Before test....."+d);
          System.out.println("Before Method");
	}
	@AfterMethod
	private void aftermothod() {
		 Date d=new Date();
         System.out.println("After test....."+d);
         System.out.println("After Method");
	}
	@Test(priority=1)
	private void test1() {
      urlLunch("https://www.flipkart.com/");
      Iphone p=new Iphone();
      btnclick(p.getBtnIntoBtn());
      sendkeys(p.getTextsearch(), "IPHONE");
      btnclick(p.getBtnsearchclick());
      List<WebElement> phones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
     List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
      
      for (int i = 0; i < phones.size(); i++) {
    	  WebElement a = phones.get(i);
	      System.out.println(a.getText());
	}
      
    for (int j = 0; j < prices.size(); j++) {
		WebElement b = prices.get(j);
		System.out.println(b.getText());
	}  
    
     
      
      
      
	}

}

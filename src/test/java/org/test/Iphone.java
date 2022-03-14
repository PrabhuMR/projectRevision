package org.test;

import java.util.List;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Iphone extends BaseClass {
	public Iphone() {
       PageFactory.initElements(driver, this);
	}
	@FindBy(name ="q")
	private WebElement textsearch;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement btnsearchclick;
	

	 
	@FindBy(xpath ="//div[@class='_4rR01T']")
	private List<WebElement> iphonelist;
	
     @FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement btnIntoBtn;

	public WebElement getTextsearch() {
		return textsearch;
	}

	public WebElement getBtnsearchclick() {
		return btnsearchclick;
	}

	public List<WebElement>  getIphonelist() {
		return iphonelist;
	}

	public WebElement getBtnIntoBtn() {
		return btnIntoBtn;
	}
		      
	}
	          



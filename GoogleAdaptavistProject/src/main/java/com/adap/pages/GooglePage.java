package com.adap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adap.base.Base;

public class GooglePage extends Base{
	
	//get elements
	@FindBy(name="q")
	WebElement searchField;
	
	
	//Initializing the Page Objects:
	public GooglePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateGooglePageTitle(){
		return driver.getTitle();
	}
	
	public SearchResultPage search(String inputName){
		searchField.sendKeys(inputName);
		searchField.submit();
		    	
		return new SearchResultPage();
	}
	
	
}

package com.adap.googletest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.adap.base.Base;
import com.adap.pages.GooglePage;
import com.adap.pages.SearchResultPage;


public class TestGooglePage extends Base{
	GooglePage googlePage;
	SearchResultPage searchResultPage;
	
	public TestGooglePage(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		googlePage = new GooglePage();
		searchResultPage= new SearchResultPage();
	}
	
	@Test(priority=1)
	public void testGooglePageTitle(){
		String title = googlePage.validateGooglePageTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority=2)
	public void validateSearchResult(){
		SearchResultPage searchResultPage = googlePage.search(prop.getProperty("inputName"));
		String resultPageLoadValidate=searchResultPage.validateSearchResultPageloaded();
		Assert.assertEquals(resultPageLoadValidate,prop.getProperty("inputName")+" - Google Search");
	}
	
	@Test(priority=3)
	public void validateUrl() throws IOException, InterruptedException{
		searchResultPage.elementsList();
	}
	
	@AfterClass
	public void tearDown(){	
		System.out.println("1. TestGooglePage Executed...");
		driver.quit();
	}
	
	
	

}
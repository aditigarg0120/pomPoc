package com.adap.googletest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.adap.base.Base;
import com.adap.pages.AtlassianSearchResultPage;
import com.adap.pages.GooglePage;
import com.adap.pages.SearchResultPage;

public class TestGooglePageScenarioTwo extends Base{
	GooglePage googlePage;
	AtlassianSearchResultPage atlassianSearchResultPage;
	
	public TestGooglePageScenarioTwo(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		googlePage = new GooglePage();
		atlassianSearchResultPage= new AtlassianSearchResultPage();
	}
	
	@Test(priority=1)
	public void testGooglePageTitle(){
		String title = googlePage.validateGooglePageTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority=2)
	public void validateSearchResult(){
		SearchResultPage searchResultPage = googlePage.search(prop.getProperty("OtherInputName"));
		String resultPageLoadValidate=searchResultPage.validateSearchResultPageloaded();
		Assert.assertEquals(resultPageLoadValidate,prop.getProperty("OtherInputName")+" - Google Search");
	}
	
	@Test(priority=3)
	public void ValidateStringPresenceinURL() throws IOException, InterruptedException{
		String atlassianSearchResult=atlassianSearchResultPage.elementsList();
		Assert.assertEquals(atlassianSearchResult, "No Adaptavist reference found");
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
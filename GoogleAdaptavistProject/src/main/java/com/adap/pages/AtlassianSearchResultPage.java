package com.adap.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adap.base.Base;

public class AtlassianSearchResultPage extends Base {

	@FindBy(className = "LC20lb")
	List<WebElement> searchResultClassname;

	// Initializing the Page Objects:
	public AtlassianSearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	// Method to get title of page
	public String validateSearchResultPageloaded() {
		return driver.getTitle();

	}

	// Method to get search list of web element which doesnot contains particular
	// string
	public String elementsList() throws InterruptedException {

		if (!searchResultClassname.isEmpty()) {
			String urlListResult = StringUtils.EMPTY;
			String pattern = ".*Adaptavist.*";
			Pattern r = Pattern.compile(pattern);
			for (int i = 0; i < searchResultClassname.size(); i++) {
				Matcher m = r.matcher(searchResultClassname.get(i).getText());
				if (m.matches()) {
					return "Reference found at " + searchResultClassname.get(i).getText();
				}
			}
			if (urlListResult.isEmpty()) {
				return "No Adaptavist reference found";
			}
		}
		return "Error in loading result page";

	}

}

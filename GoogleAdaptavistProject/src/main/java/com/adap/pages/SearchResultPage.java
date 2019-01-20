package com.adap.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adap.base.Base;
import com.adap.util.Utility;

public class SearchResultPage extends Base {

	@FindBy(className = "LC20lb")
	List<WebElement> searchResultClassname;

	// Initializing the Page Objects:
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	// Method to get title of page
	public String validateSearchResultPageloaded() {
		return driver.getTitle();

	}

	// Method to get search list of web element which contains particular string
	// and takes screenshot while navigating to each page
	public void elementsList() throws InterruptedException {

		String pagesearch = driver.getCurrentUrl();
		if (!searchResultClassname.isEmpty()) {
			System.out.println(searchResultClassname.size());
			String pattern = ".*Adaptavist.*";
			Pattern r = Pattern.compile(pattern);
			for (int i = 0; i < searchResultClassname.size(); i++) {
				try {
					Matcher m = r.matcher(searchResultClassname.get(i).getText());
					if (m.matches()) {
						System.out.println("Element" + searchResultClassname.get(i));
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
						searchResultClassname.get(i).click();
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
						Utility.takeScreenshotAtEndOfTest("Url_" + (i + 1) + "_");
						driver.navigate().to(pagesearch);
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

					}
				} catch (TimeoutException e) {
					System.out.println(
							"Page: " + searchResultClassname.get(i).getText() + " did not load within 40 seconds!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}

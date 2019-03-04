package com.mycompany.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageMethods {
	protected WebDriver driver;
//	public ExtentTest extentTest = new TestBaseER().extentTest;
	JSEHelper js = new JSEHelper();
	
	public PageMethods() {
		
	}
	public PageMethods(WebDriver driver) {
		this.driver=driver;
	}
	
	

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOn(WebElement element) {
		element.click();
//		extentTest.log(LogStatus.INFO, " Clicking on: " + element);
	}
	public void typeThis(WebElement locator, String value) {
		
		locator.sendKeys(value);
//		extentTest.log(LogStatus.INFO, "Typing in: "+locator+" entering the value of: "+value);
	}
	public void autoSuggestiveSelector(WebElement element,String airportLocationsXPATH,String searchValue) {
		
		clickOn(element);
		typeThis(element,searchValue);
		List<WebElement> locations=driver.findElements(By.xpath(airportLocationsXPATH));
		System.out.println("Total locations: " + locations.size());
		for(WebElement location:locations)

        {
                    if(location.getText().contains(searchValue)) {
                    	location.click();
                    	break;
                    }
        }
	}
	
}

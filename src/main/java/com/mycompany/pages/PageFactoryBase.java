package com.mycompany.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageFactoryBase {

	protected WebDriver driver;
	JSEHelper js = new JSEHelper();
	public ExtentTest extentTest;
	
	public PageFactoryBase(WebDriver driver) 
    {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOn(WebElement element) {
		element.click();
		//extentTest.log(LogStatus.INFO, " Clicking on: " + element);
	}
	public void typeThis(WebElement locator, String value) {
		
		locator.sendKeys(value);
		//extentTest.log(LogStatus.INFO, "Typing in: "+locator+" entering the value of: "+value);
	}
	public void autoSuggestiveSelector(WebElement element,String airportLocationsXPATH,String searchValue) {
		
		clickOn(element);
		typeThis(element,searchValue);
		List<WebElement> locations=driver.findElements(By.xpath(airportLocationsXPATH));
		System.out.println("Total locations: " + locations.size());
		for(WebElement location:locations){
			
			  if(location.getText().contains(searchValue)) {
                    	location.click();
                    	break;
                    }
        }
	}
	
	// PAGE FACTORY

	// XPATH strings
	String locationListXpath = "//ul[@id='typeaheadDataPlain']/div/li/a";

	// Flights Menu
	@FindBy(xpath = "//a[@title='About Us']")
	WebElement about;

	@FindBy(id = "tab-flight-tab-hp")
	WebElement flightTab;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement roundTripOption;

	@FindBy(id = "flight-type-one-way-label-hp-flight")
	WebElement oneWayOption;

	@FindBy(id = "flight-type-multi-dest-label-hp-flight")
	WebElement multiCityOption;

	@FindBy(id = "flight-origin-hp-flight")
	WebElement originAirport;

	@FindBy(xpath = "//input[@id='flight-destination-hp-flight']")
	WebElement destinationAirport;

	@FindBy(id = "flight-departing-hp-flight")
	WebElement departingDate;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement returningDate;

	@FindBy(id = "flexibleDate")
	WebElement flexibleDateRadio;

	@FindBy(id = "flight-advanced-options-hp-flight")
	WebElement advanceOptionsMenu;

	@FindBy(id = "advanced-flight-nonstop-hp-flight")
	WebElement nonStopOptionRadio;

	@FindBy(id = "flight-advanced-preferred-airline-hp-flight")
	WebElement preferedAirlineDropDown;

	@FindBy(id = "flight-add-hotel-checkbox-hp-flight")
	WebElement addHotelRadio;

	@FindBy(xpath = "(//button[@class='btn-primary btn-action gcw-submit '])[1]")
	WebElement flightSearchButton;
	
	@FindBy(id = "departure-airport-1")
	WebElement flightResultsDeparture;

	@FindBy(id = "arrival-airport-1")
	WebElement flightResultsArrival;
	
	@FindBy(id = "departure-date-1")
	WebElement flightResultsdepartDate;
	
	@FindBy(xpath = "//a[@class='error-link']")
	WebElement flightSelectErrorMessage;
	
	
}
